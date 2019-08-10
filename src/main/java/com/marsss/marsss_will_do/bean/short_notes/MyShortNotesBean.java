package com.marsss.marsss_will_do.bean.short_notes;

import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class MyShortNotesBean implements Serializable{

    private String id;
    private String content;
    private UserAccount userAccount;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate ;    //项目开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate ;

    private String remark ;

    private String createDateStr ;
    private String modifyDateStr ;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getModifyDateStr() {
        return modifyDateStr;
    }

    public void setModifyDateStr(String modifyDateStr) {
        this.modifyDateStr = modifyDateStr;
    }
}
