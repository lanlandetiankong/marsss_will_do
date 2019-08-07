package com.marsss.marsss_will_do.bean.project;

import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public class ArchiveProjectBean {

    private String id ;
    private String name ;
    private String desc ;
    private Integer totalTaskCount ;   //总任务数
    private Integer finishTaskCount;    //已完成
    private Double progressRate ;   //进度

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
