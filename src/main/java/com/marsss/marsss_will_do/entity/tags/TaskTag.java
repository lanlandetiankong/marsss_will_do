package com.marsss.marsss_will_do.entity.tags;

import com.marsss.marsss_will_do.common.base.repository.MyBaseEntity;
import com.marsss.marsss_will_do.entity.tasks.Task;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "task_tag", schema = "mars_will_do")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class TaskTag extends MyBaseEntity {
    @Id
    @Column(name = "task_tag_id")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id",nullable = false,insertable = true)
    private Task task;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id",nullable = false,insertable = true)
    private Tag Tag;


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

    public com.marsss.marsss_will_do.entity.tags.Tag getTag() {
        return Tag;
    }

    public void setTag(com.marsss.marsss_will_do.entity.tags.Tag tag) {
        Tag = tag;
    }
}
