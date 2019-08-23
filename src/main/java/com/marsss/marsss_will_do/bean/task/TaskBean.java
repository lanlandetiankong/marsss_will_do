package com.marsss.marsss_will_do.bean.task;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;

public class TaskBean {

    private String id;
    private String name;
    private String nameSpell;
    private String userAccountId;

    private String presenter;   //提出人员
    private String participant;     //参与人员
    private String taskLevel;

    private String activityProjectId;
    private String archiveProjectId;

    private String description;
    //进度
    private Integer progressRate ;
    private String progressRateStatus ;
    private String progressRateShowText ;
    private Integer progressIsException ;
    private String progressExceptionNote ;


    private String firstNote;
    private String secondNote;
    private String thirdNote;
    private Integer status;
    private String progressId;
    private Timestamp planStartDate;
    private Timestamp planEndDate;
    private String planStartDateStr;
    private String planEndDateStr;

    private  Integer sort ;
    private String remark ;

    private Date createDateVal ;
    private Date modifyDateVal ;

    private String createDateStr ;
    private String modifyDateStr ;

    private String vueElType;
    private String vueElIcon ;

    public String getProgressExceptionNote() {
        return progressExceptionNote;
    }

    public void setProgressExceptionNote(String progressExceptionNote) {
        this.progressExceptionNote = progressExceptionNote;
    }

    public Integer getProgressIsException() {
        return progressIsException;
    }

    public void setProgressIsException(Integer progressIsException) {
        this.progressIsException = progressIsException;
    }

    public String getProgressRateShowText() {
        return progressRateShowText;
    }

    public void setProgressRateShowText(String progressRateShowText) {
        this.progressRateShowText = progressRateShowText;
    }

    public String getProgressRateStatus() {
        return progressRateStatus;
    }

    public void setProgressRateStatus(String progressRateStatus) {
        this.progressRateStatus = progressRateStatus;
    }

    public Integer getProgressRate() {
        return progressRate;
    }

    public void setProgressRate(Integer progressRate) {
        this.progressRate = progressRate;
    }

    public String getPlanStartDateStr() {
        return planStartDateStr;
    }

    public void setPlanStartDateStr(String planStartDateStr) {
        this.planStartDateStr = planStartDateStr;
    }

    public String getPlanEndDateStr() {
        return planEndDateStr;
    }

    public void setPlanEndDateStr(String planEndDateStr) {
        this.planEndDateStr = planEndDateStr;
    }

    public String getVueElType() {
        return vueElType;
    }

    public void setVueElType(String vueElType) {
        this.vueElType = vueElType;
    }

    public String getVueElIcon() {
        return vueElIcon;
    }

    public void setVueElIcon(String vueElIcon) {
        this.vueElIcon = vueElIcon;
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

    public Date getCreateDateVal() {
        return createDateVal;
    }

    public void setCreateDateVal(Date createDateVal) {
        this.createDateVal = createDateVal;
    }

    public Date getModifyDateVal() {
        return modifyDateVal;
    }

    public void setModifyDateVal(Date modifyDateVal) {
        this.modifyDateVal = modifyDateVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(String taskLevel) {
        this.taskLevel = taskLevel;
    }

    public String getActivityProjectId() {
        return activityProjectId;
    }

    public void setActivityProjectId(String activityProjectId) {
        this.activityProjectId = activityProjectId;
    }

    public String getArchiveProjectId() {
        return archiveProjectId;
    }

    public void setArchiveProjectId(String archiveProjectId) {
        this.archiveProjectId = archiveProjectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstNote() {
        return firstNote;
    }

    public void setFirstNote(String firstNote) {
        this.firstNote = firstNote;
    }

    public String getSecondNote() {
        return secondNote;
    }

    public void setSecondNote(String secondNote) {
        this.secondNote = secondNote;
    }

    public String getThirdNote() {
        return thirdNote;
    }

    public void setThirdNote(String thirdNote) {
        this.thirdNote = thirdNote;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    public Timestamp getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Timestamp planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Timestamp getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Timestamp planEndDate) {
        this.planEndDate = planEndDate;
    }
}
