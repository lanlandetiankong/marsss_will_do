package com.marsss.marsss_will_do.bean.project;

import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import javax.transaction.Transactional;
import java.util.Date;

public class ActivityProjectBean {
    private String id ;
    private String name ;
    private String description ;
    private Integer totalTaskCount ;   //总任务数
    private Integer finishTaskCount;    //已完成
    private Double progressRate ;   //进度

    private String baseType;       //基本类型
    private String goal;        //目标
    private String hurryLevel; //紧急级别
    private String firstNote;   //便签1
    private String secondNote;  //便签2
    private String remark ;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate ;    //项目开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate ;
    private Integer sort ;

    private Integer isTranslateArchive ;
    private String archiveProjectId ;       //归档项目id


    public Integer getIsTranslateArchive() {
        return isTranslateArchive;
    }

    public void setIsTranslateArchive(Integer isTranslateArchive) {
        this.isTranslateArchive = isTranslateArchive;
    }

    public String getArchiveProjectId() {
        return archiveProjectId;
    }

    public void setArchiveProjectId(String archiveProjectId) {
        this.archiveProjectId = archiveProjectId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getHurryLevel() {
        return hurryLevel;
    }

    public void setHurryLevel(String hurryLevel) {
        this.hurryLevel = hurryLevel;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getTotalTaskCount() {
        return totalTaskCount;
    }

    public void setTotalTaskCount(Integer totalTaskCount) {
        this.totalTaskCount = totalTaskCount;
    }

    public Integer getFinishTaskCount() {
        return finishTaskCount;
    }

    public void setFinishTaskCount(Integer finishTaskCount) {
        this.finishTaskCount = finishTaskCount;
    }

    public Double getProgressRate() {
        return progressRate;
    }

    public void setProgressRate(Double progressRate) {
        this.progressRate = progressRate;
    }
}
