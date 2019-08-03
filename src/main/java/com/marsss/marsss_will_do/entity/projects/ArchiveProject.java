package com.marsss.marsss_will_do.entity.projects;

import com.marsss.marsss_will_do.common.base.repository.MyBaseEntity;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "archive_project", schema = "mars_will_do")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class ArchiveProject extends MyBaseEntity {
    @Id
    @Column(name = "archive_project_id")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    private String name;
    private String code;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id",nullable = true)
    private UserAccount userAccount;

    private Integer baseType;
    private String groupId;
    private Integer sort;
    private String goal;
    private Integer hurryLevel;
    private String firstNote;
    private String secondNote;
    private String description;


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
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
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
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "goal")
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Basic
    @Column(name = "hurry_level")
    public Integer getHurryLevel() {
        return hurryLevel;
    }

    public void setHurryLevel(Integer hurryLevel) {
        this.hurryLevel = hurryLevel;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
