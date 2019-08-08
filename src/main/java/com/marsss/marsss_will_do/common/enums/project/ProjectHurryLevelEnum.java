package com.marsss.marsss_will_do.common.enums.project;

<<<<<<< HEAD
public enum ProjectHurryLevelEnum {
    VERY(20,"特别急","特别急"),
    MORE(40,"较着急","较着急"),
    LITTLE(60,"有点急","有点急"),
    SIMPLE(80,"普通","普通"),
    GENERAL(100,"一般","一般"),
    NO_AT_ALL(120,"不着急","不着急")

    ;

    ProjectHurryLevelEnum(Integer value, String name, String info) {
        this.value = value;
        this.name = name;
        this.info = info;
    }

    private Integer value ;
    private String name ;
    private String info ;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
=======

import java.util.HashMap;
import java.util.Map;

public enum ProjectHurryLevelEnum {
    VERY("Very","Very","特别急",20),
    MORE("More","More","较着急",40),
    LITTLE("Little","Little","有点急",60),
    SIMPLE("Simple","Simple","普通",80),
    GENERAL("General","General","一般",100),
    NO_AT_ALL("NoAtAll","NoAtAll","不着急",120)
    ;

    ProjectHurryLevelEnum(String key, String value, String label,  Integer numVal) {
        this.key = key;
        this.value = value;
        this.label = label;
        this.numVal = numVal;
    }

    private String key ;
    private String value ;
    private String label ;
    private Integer numVal ;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public Integer getNumVal() {
        return numVal;
    }

    public void setNumVal(Integer numVal) {
        this.numVal = numVal;
    }

    public Map<String,Object> toMap() {
        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("key",this.key);
        map.put("value",this.value);
        map.put("label",this.label);
        map.put("numVal",this.numVal);
        return map ;
    }

>>>>>>> temp
}
