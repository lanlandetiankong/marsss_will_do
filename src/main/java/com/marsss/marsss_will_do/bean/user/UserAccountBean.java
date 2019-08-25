package com.marsss.marsss_will_do.bean.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserAccountBean {
    private String id;

    private String userName ;
    private String nickName ;
    private String userNameSpell ;
    private String nickNameSpell ;

    private String account ;
    private String password ;

    private String userAccountInfoId ;

    private Integer sex ;
    private String telephone ;
    private String email ;
    private Integer baseType ;
    private Integer registerType;

    private String validateCode ;   //验证码


    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBaseType() {
        return baseType;
    }

    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public String getUserNameSpell() {
        return userNameSpell;
    }

    public void setUserNameSpell(String userNameSpell) {
        this.userNameSpell = userNameSpell;
    }

    public String getNickNameSpell() {
        return nickNameSpell;
    }

    public void setNickNameSpell(String nickNameSpell) {
        this.nickNameSpell = nickNameSpell;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserAccountInfoId() {
        return userAccountInfoId;
    }

    public void setUserAccountInfoId(String userAccountInfoId) {
        this.userAccountInfoId = userAccountInfoId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
