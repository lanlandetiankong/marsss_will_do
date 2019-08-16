package com.marsss.marsss_will_do.entity.tasks;

import com.marsss.marsss_will_do.common.base.repository.MyBaseEntity;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task", schema = "mars_will_do")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Task  extends MyBaseEntity {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    private String name;
    private String nameSpell;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id",nullable = false)
    private UserAccount userAccount;

    private String presenter;   //提出人员
    private String participant;     //参与人员
    private Integer taskLevel;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_project_id",nullable = true)
    private ActivityProject activityProject;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "archive_project_id",nullable = true)
    private ArchiveProject archiveProject;

    private String description;
    private String firstNote;
    private String secondNote;
    private String thirdNote;
    private Integer status;
    private String progressId;
    private Timestamp planStartDate;
    private Timestamp planEndDate;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "name_spell")
    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "presenter")
    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    @Basic
    @Column(name = "participant")
    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    @Basic
    @Column(name = "task_level")
    public Integer getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(Integer taskLevel) {
        this.taskLevel = taskLevel;
    }


    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "first_note")
    public String getFirstNote() {
        return firstNote;
    }

    public void setFirstNote(String firstNote) {
        this.firstNote = firstNote;
    }

    @Basic
    @Column(name = "second_note")
    public String getSecondNote() {
        return secondNote;
    }

    public void setSecondNote(String secondNote) {
        this.secondNote = secondNote;
    }

    @Basic
    @Column(name = "third_note")
    public String getThirdNote() {
        return thirdNote;
    }

    public void setThirdNote(String thirdNote) {
        this.thirdNote = thirdNote;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "progress_id")
    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    @Basic
    @Column(name = "plan_start_date")
    public Timestamp getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Timestamp planStartDate) {
        this.planStartDate = planStartDate;
    }

    @Basic
    @Column(name = "plan_end_date")
    public Timestamp getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Timestamp planEndDate) {
        this.planEndDate = planEndDate;
    }


    public ActivityProject getActivityProject() {
        return activityProject;
    }

    public void setActivityProject(ActivityProject activityProject) {
        this.activityProject = activityProject;
    }

    public ArchiveProject getArchiveProject() {
        return archiveProject;
    }

    public void setArchiveProject(ArchiveProject archiveProject) {
        this.archiveProject = archiveProject;
    }
}
