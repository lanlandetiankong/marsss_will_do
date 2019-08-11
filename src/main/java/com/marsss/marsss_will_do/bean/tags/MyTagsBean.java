package com.marsss.marsss_will_do.bean.tags;

import com.marsss.marsss_will_do.entity.user.UserAccount;

public class MyTagsBean {
    private String id;
    private String name;
    private String hurryLevel;
    private String hurryLevelShow ;

    private String firstNote;
    private String secondNote;
    private Integer type;



    public String getHurryLevelShow() {
        return hurryLevelShow;
    }

    public void setHurryLevelShow(String hurryLevelShow) {
        this.hurryLevelShow = hurryLevelShow;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
