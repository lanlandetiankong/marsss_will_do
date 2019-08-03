package com.marsss.marsss_will_do.entity.tasks;

import com.marsss.marsss_will_do.common.base.repository.MyBaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sub_task", schema = "mars_will_do")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SubTask extends MyBaseEntity {
    @Id
    @Column(name = "sub_task_id")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id",nullable = false)
    private Task task;

    private String name;
    private String referUserName;
    private String firstNote;
    private String userAccountId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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
    @Column(name = "refer_user_name")
    public String getReferUserName() {
        return referUserName;
    }

    public void setReferUserName(String referUserName) {
        this.referUserName = referUserName;
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
    @Column(name = "user_account_id")
    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

}
