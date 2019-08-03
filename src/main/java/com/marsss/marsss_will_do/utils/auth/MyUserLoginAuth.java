package com.marsss.marsss_will_do.utils.auth;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.apache.commons.lang.StringUtils;

public class MyUserLoginAuth {
    /**
     * 验证账号是否有效/登录
     * @param userAccountBean
     * @return
     */
    public static boolean authIsUserLogin(UserAccountBean userAccountBean) {
        boolean flag = true ;
        if(userAccountBean == null) {
            flag = false ;
            throw new SecurityException("用户未登录！");
        }
        return flag;
    }
    /**
     * 验证账号是否有效/登录
     * @param userAccount
     * @return
     */
    public static boolean authIsUserLogin(UserAccount userAccount) {
        boolean flag = true ;
        if(userAccount == null) {
            flag = false ;
            throw new SecurityException("用户未登录！");
        }
        if(StringUtils.isBlank(userAccount.getId())){
            flag = false ;
        }
        return flag ;
    }

}
