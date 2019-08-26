package com.marsss.marsss_will_do.common.exception.user;

public class UserAccountRegisteredException extends RuntimeException{
    private static final long serialVersionUID = 456412449116225748L;


    public UserAccountRegisteredException(String prefix,String message) {
        super(prefix+" < "+message+" >已被注册，请重新填写注册信息");
    }
    public UserAccountRegisteredException(String message) {
        super("< "+message+" >已被注册，请重新填写注册信息");
    }


    public UserAccountRegisteredException() {
        super("该用户账号已被注册，请重新填写注册信息");
    }
}
