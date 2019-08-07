package com.marsss.marsss_will_do.service.user;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.bean.user.UserToken;
import com.marsss.marsss_will_do.common.base.service.MyBaseServiceImpl;
import com.marsss.marsss_will_do.common.constant.exception.MyExceptionMsgConstant;
import com.marsss.marsss_will_do.common.enums.user.UserAccountBaseTypeEnum;
import com.marsss.marsss_will_do.common.enums.user.UserAccountRegisterTypeEnum;
import com.marsss.marsss_will_do.common.enums.user.UserAccountStateEnum;
import com.marsss.marsss_will_do.common.exception.user.UserAccountEmptyException;
import com.marsss.marsss_will_do.common.properties.UserCustomProperties;
import com.marsss.marsss_will_do.common.test.RandomValueUtil;
import com.marsss.marsss_will_do.config.redis.RedisHelper;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.utils.password.MyPasswordUtil;
import com.marsss.marsss_will_do.utils.pinyin.MyPinYinUtil;
import com.marsss.marsss_will_do.utils.uuid.MyUUIDUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.query.Query;
import org.hibernate.query.internal.QueryImpl;
import org.springframework.data.domain.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

@Service
public class UserAccountServiceImpl extends MyBaseServiceImpl implements UserAccountService {

    private Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);
    @Autowired
    private RedisHelper redisHelper;
    @Autowired
    private UserCustomProperties userCustomProperties ;
    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private UserAccountInfoService userAccountInfoService ;

    @Override
    public UserAccount doAddUserAccount(UserAccount userAccount) {
        userAccount = null != userAccount ? userAccount : new UserAccount() ;
        userAccount.setEmail(RandomValueUtil.getEmail(10,15));
        userAccount.setSex(1);
        //用户名
        userAccount.setNickName(RandomValueUtil.getChineseName());
        userAccount.setNickNameSpell(MyPinYinUtil.toPinyin(userAccount.getNickName()));
        userAccount.setUserName(RandomValueUtil.getChineseName());
        userAccount.setUserNameSpell(MyPinYinUtil.toPinyin(userAccount.getUserName()));
        userAccount.setAccount(userAccount.getNickNameSpell());
        //密码
        userAccount.setSalt(MyUUIDUtil.renderSimpleUUID());
        userAccount.setPassword(MyPasswordUtil.renderMd5Password(userCustomProperties.getDefaultPassword(),userAccount.getSalt()));
        userAccount.setTelephone(RandomValueUtil.getTel());

        //用户信息
        userAccount.setUserAccountInfo(userAccountInfoService.doGetPreAddUserAccountInfoVo());

        userAccount.setBaseType(UserAccountBaseTypeEnum.SIMPLE_USER.getValue());
        userAccount.setRegisterType(UserAccountRegisterTypeEnum.FRONT_REGISTER.getValue());
        userAccount.setState(UserAccountStateEnum.ENABLED.getValue());
        userAccountRepository.save(userAccount) ;
        return userAccount;
    }
    @Override
    public UserAccount doAddUserAccount(UserAccountBean userAccountBean) throws IllegalAccessException,InvocationTargetException{
        if(userAccountBean == null) {
            throw new NullPointerException(MyExceptionMsgConstant.NULL_OBJECT_INTRO) ;
        }
        UserAccount vo = new UserAccount() ;
        BeanUtils.copyProperties(vo,userAccountBean);
        return doAddUserAccount(vo);
    }

    @Override
    public UserAccount doGetUserAccountByAccountId(String accountId) {
        return userAccountRepository.getUserAccountByUserAccount(accountId);
    }

    @Override
    public boolean doCheckIsAccountExistByAccount(String accountId) {
        return userAccountRepository.getUserAccountByUserAccount(accountId) != null ;
    }





    /**
     * 根据token id 取得 用户信息
     * (TODO：根据token从Redis取得对应真实的Token,再 让(token+sessionId) 进行md5 加密，判断是否 与Token.md5Token )
     * @param tokenId
     * @param  isThrowException Redis用户token不存在时，是否抛出异常
     * @return
     */
    @Override
    public UserAccount tokenIdToUserAccount(HttpServletRequest request, String tokenId, boolean isThrowException) {
        Object redisObj =  redisHelper.getValue(tokenId);
        if(redisObj == null){
            if(isThrowException) {
                throw new UserAccountEmptyException("用户Token不存在，请重新登录！");
            }   else {
                return null ;
            }
        }   else {
            UserToken userToken = (UserToken) redisObj ;
            return userAccountRepository.findById(userToken.getUserId()).get() ;
        }
    }

    @Override
    public UserAccount requestGetUserAccount(HttpServletRequest request,boolean isThrowException) {
        String tokenId = request.getHeader("token");
        if(StringUtils.isBlank(tokenId)) {
            if(isThrowException) {
                throw new UserAccountEmptyException("会话信息已失效！");
            }   else {
                return null ;
            }
        }
        return this.tokenIdToUserAccount(request,tokenId,isThrowException) ;
    }
}

