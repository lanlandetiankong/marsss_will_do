package com.marsss.marsss_will_do.entity.tags;

import com.marsss.marsss_will_do.common.base.repository.MyBaseEntity;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "my_tags", schema = "mars_will_do")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class MyTags extends MyBaseEntity {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    private String name;
    @Basic
    @Column(name = "hurry_level")
    private String hurryLevel;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id",nullable = true)
    private UserAccount userAccount;


    private String firstNote;
    private String secondNote;
    private Integer type;


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

    public String getHurryLevel() {
        return hurryLevel;
    }

    public void setHurryLevel(String hurryLevel) {
        this.hurryLevel = hurryLevel;
    }




    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
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
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
