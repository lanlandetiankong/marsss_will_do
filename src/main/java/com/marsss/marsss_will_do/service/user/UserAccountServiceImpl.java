package com.marsss.marsss_will_do.service.user;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.common.constant.exception.MyExceptionMsgConstant;
import com.marsss.marsss_will_do.common.enums.user.UserAccountBaseTypeEnum;
import com.marsss.marsss_will_do.common.enums.user.UserAccountRegisterTypeEnum;
import com.marsss.marsss_will_do.common.enums.user.UserAccountStateEnum;
import com.marsss.marsss_will_do.common.properties.UserCustomProperties;
import com.marsss.marsss_will_do.common.test.RandomValueUtil;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.utils.password.MyPasswordUtil;
import com.marsss.marsss_will_do.utils.pinyin.MyPinYinUtil;
import com.marsss.marsss_will_do.utils.uuid.MyUUIDUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.query.Query;
import org.hibernate.query.internal.QueryImpl;
import org.springframework.data.domain.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);
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

    public void test(String accountId) {
        ExampleMatcher exampleMatcher  = ExampleMatcher.matching();
        userAccountRepository.findAll();
    }
}

