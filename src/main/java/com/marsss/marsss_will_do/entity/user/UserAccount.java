package com.marsss.marsss_will_do.entity.user;

import com.marsss.marsss_will_do.common.base.repository.MyBaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_account", schema = "mars_will_do")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserAccount extends MyBaseEntity {
    @Id
    @Column(name = "user_account_id")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    private String userName;
    private String nickName;
    private String userNameSpell;
    private String nickNameSpell;
    private String account;
    private String salt;
    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_info_id",nullable = false,insertable = true)
    private UserAccountInfo userAccountInfo;

    private Integer sex;
    private String telephone;
    private String email;
    private Integer baseType;
    private Integer registerType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "user_name_spell")
    public String getUserNameSpell() {
        return userNameSpell;
    }

    public void setUserNameSpell(String userNameSpell) {
        this.userNameSpell = userNameSpell;
    }

    @Basic
    @Column(name = "nick_name_spell")
    public String getNickNameSpell() {
        return nickNameSpell;
    }

    public void setNickNameSpell(String nickNameSpell) {
        this.nickNameSpell = nickNameSpell;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccountInfo getUserAccountInfo() {
        return userAccountInfo;
    }

    public void setUserAccountInfo(UserAccountInfo userAccountInfo) {
        this.userAccountInfo = userAccountInfo;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "base_type")
    public Integer getBaseType() {
        return baseType;
    }

    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    @Basic
    @Column(name = "register_type")
    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(userNameSpell, that.userNameSpell) &&
                Objects.equals(nickNameSpell, that.nickNameSpell) &&
                Objects.equals(account, that.account) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(password, that.password) &&
                Objects.equals(userAccountInfo, that.userAccountInfo) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(baseType, that.baseType) &&
                Objects.equals(registerType, that.registerType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, nickName, userNameSpell, nickNameSpell, account, salt, password, userAccountInfo, sex, telephone, email, baseType, registerType);
    }
}
