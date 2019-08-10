package com.marsss.marsss_will_do.common.enums.task;


import java.util.HashMap;
import java.util.Map;

public enum TaskHurryLevelEnum {
    VERY("ImportanceAndHurry","ImportanceAndHurry","很重要-很急",20),
    MORE("ImportanceAndUnHurry","ImportanceAndUnHurry","重要-不紧急",40),
    LITTLE("UnImportanceAndHurry","UnImportanceAndHurry","不重要-紧急",60),
    SIMPLE("UnImportanceAndUnHurry","UnImportanceAndUnHurry","不重要不紧急",80),
    ;

    TaskHurryLevelEnum(String key, String value, String label, Integer numVal) {
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

}
