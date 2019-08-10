package com.marsss.marsss_will_do.entity.short_notes;

import com.marsss.marsss_will_do.common.base.repository.MyBaseEntity;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "my_short_note", schema = "mars_will_do")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class MyShortNotes extends MyBaseEntity {
    @Id
    @Column(name = "short_note_id")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Basic
    @Column(name = "content")
    private String content;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id",nullable = true)
    private UserAccount userAccount;


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
}
