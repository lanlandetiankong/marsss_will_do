package com.marsss.marsss_will_do.service.user;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.entity.user.UserAccount;

import java.lang.reflect.InvocationTargetException;

public interface UserAccountService {
    UserAccount doAddUserAccount(UserAccount userAccount) ;
    UserAccount doAddUserAccount(UserAccountBean userAccountBean) throws IllegalAccessException,InvocationTargetException ;




    UserAccount doGetUserAccountByAccountId(String accountId);
    boolean doCheckIsAccountExistByAccount(String accountId) ;
}
