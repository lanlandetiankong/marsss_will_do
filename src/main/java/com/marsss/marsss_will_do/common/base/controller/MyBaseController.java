package com.marsss.marsss_will_do.common.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.marsss.marsss_will_do.bean.user.UserToken;
import com.marsss.marsss_will_do.bean.user.UserTokenBean;
import com.marsss.marsss_will_do.bean.user.UserTokenBeanFormat;
import com.marsss.marsss_will_do.common.exception.user.UserAccountEmptyException;
import com.marsss.marsss_will_do.config.redis.RedisHelper;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.user.UserAccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyBaseController {
    @Autowired
    private RedisHelper redisHelper ;
    @Autowired
    private UserAccountService userAccountService ;
    @Autowired
    private UserAccountRepository userAccountRepository ;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    /**
     * 目前只是判断token是否存在
     * (TODO：根据token从Redis取得对应真实的Token,再 让(token+sessionId) 进行md5 加密，判断是否 与Token.md5Token )
     * @param request
     * @param isThrowException 用户token不存在时，是否抛出异常
     * @return
     */
    public UserAccount handleCheckIsUserAccountToken(HttpServletRequest request,boolean isThrowException) {
        String tokenId = request.getHeader("token");
        if(StringUtils.isBlank(tokenId)) {
            if(isThrowException) {
                throw new UserAccountEmptyException("会话信息已失效！");
            }   else {
                return null ;
            }
        }
        UserAccount userAccount = userAccountService.tokenIdToUserAccount(request,tokenId,isThrowException);
        return userAccount ;
    }


    /**
     * 登录时缓存 token 到Redis
     * @param request
     * @return
     */
    public UserTokenBean handleLoginCacheUserToken(HttpServletRequest request, UserAccount userAccount) {
        if(userAccount == null) {
            throw new UserAccountEmptyException("传入的用户信息为空！") ;
        }
        UserToken token = UserTokenBeanFormat.userAccountToUserToken(request,userAccount) ;
        //存的 UserToken
        redisHelper.valuePut(token.getId(),token);
        //返回的是 UserTokenBean
        return UserTokenBeanFormat.userTokenToBean(token);
    }

}
