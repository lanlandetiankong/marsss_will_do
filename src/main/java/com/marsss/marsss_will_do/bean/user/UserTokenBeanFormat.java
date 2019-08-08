package com.marsss.marsss_will_do.bean.user;

import com.marsss.marsss_will_do.common.exception.user.UserAccountEmptyException;
import com.marsss.marsss_will_do.config.redis.RedisHelper;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.utils.password.MyPasswordUtil;
import com.marsss.marsss_will_do.utils.uuid.MyUUIDUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.owasp.esapi.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserTokenBeanFormat {

    /**
     * 根据用户账号，生成 tokenBean,存储到 Redis , 转化为 token 返回给前端
     * tokenid 返回给前端，后端根据 tokenid + sessionid 判断用户登录
     * @param request
     * @param account
     * @return
     */
    public static UserToken  userAccountToUserToken(HttpServletRequest request,UserAccount account) {
        UserToken token = new UserToken() ;
        token.setUserId(account.getId());
        HttpSession session = request.getSession();
        token.setSessionId(session.getId());
        token.setId(MyUUIDUtil.renderSimpleUUID());
        //md5Token :  tokenId + sessionId
        token.setMd5Token(MyPasswordUtil.renderMd5Password(token.getId(),token.getSessionId()));
        return token ;
    }

    /**
     * 取得返回给前端的token
     * @param token
     * @return
     */
    public static UserTokenBean  userTokenToBean(UserToken token) {
        UserTokenBean bean = new UserTokenBean() ;
        bean.setUserId(token.getUserId());
        bean.setId(token.getId());
        return bean ;
    }

}
