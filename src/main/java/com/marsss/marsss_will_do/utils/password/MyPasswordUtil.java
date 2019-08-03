package com.marsss.marsss_will_do.utils.password;

import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.springframework.util.DigestUtils;

public class MyPasswordUtil {
    public static String renderMd5Password(String password,String salt) {
        password = password != null ? password : "" ;
        salt = salt != null ? salt : "" ;
        return  DigestUtils.md5DigestAsHex(new String(password+salt).getBytes()) ;
    }

    /**
     * 验证密码是否正确
     * @param password 前端传递的未加密的密码
     * @param salt 盐
     * @param dbPassword 数据库中的密码
     * @return
     */
    public static boolean varifyMd5PasswordIsTrue(String password,String salt,String dbPassword) {
        boolean flag = false ;
        password = password != null ? password : "" ;
        salt = salt != null ? salt : "" ;
         String tempMd5Pwd = DigestUtils.md5DigestAsHex(new String(password+salt).getBytes()) ;
         if(tempMd5Pwd.equals(dbPassword)) {
             flag = true ;
         }
         return flag ;
    }

    /**
     * 验证密码是否正确
     * @param password 前端传递的未加密的密码
     * @param userAccount
     * @return
     */
    public static boolean varifyMd5PasswordIsTrue(String password, UserAccount userAccount) {
        boolean flag = false ;
        password = password != null ? password : "" ;
        flag = varifyMd5PasswordIsTrue(password,userAccount.getAccount(),userAccount.getPassword()) ;
        return flag ;
    }
}
