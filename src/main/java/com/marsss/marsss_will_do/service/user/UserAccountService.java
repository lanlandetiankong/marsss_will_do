package com.marsss.marsss_will_do.service.user;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
<<<<<<< HEAD
import com.marsss.marsss_will_do.entity.user.UserAccount;

import java.lang.reflect.InvocationTargetException;

public interface UserAccountService {
=======
import com.marsss.marsss_will_do.common.base.service.MyBaseService;
import com.marsss.marsss_will_do.entity.user.UserAccount;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public interface UserAccountService extends MyBaseService {
>>>>>>> temp
    UserAccount doAddUserAccount(UserAccount userAccount) ;
    UserAccount doAddUserAccount(UserAccountBean userAccountBean) throws IllegalAccessException,InvocationTargetException ;




    UserAccount doGetUserAccountByAccountId(String accountId);
    boolean doCheckIsAccountExistByAccount(String accountId) ;
<<<<<<< HEAD
=======
    /**
     * 根据token id 取得 用户信息
     * (TODO：根据token从Redis取得对应真实的Token,再 让(token+sessionId) 进行md5 加密，判断是否 与Token.md5Token )
     * @param tokenId
     * @param  isThrowException Redis用户token不存在时，是否抛出异常
     * @return
     */
    UserAccount tokenIdToUserAccount(HttpServletRequest request, String tokenId, boolean isThrowException);

    /**
     * 从request取得 当前登录用户
     * @param request
     * @param isThrowException Redis用户token不存在时，是否抛出异常
     * @return
     */
    UserAccount requestGetUserAccount(HttpServletRequest request,boolean isThrowException);
>>>>>>> temp
}
