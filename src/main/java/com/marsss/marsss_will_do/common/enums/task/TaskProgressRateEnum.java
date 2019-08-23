package com.marsss.marsss_will_do.common.enums.task;

import java.util.HashMap;
import java.util.Map;

public enum TaskProgressRateEnum {
    DEFAULT("default",null,"进行中",0,"任务进行中"),
    SUCCESS("success","success","任务已完成",100,"任务已完成"),
    EXCEPTION("exception","exception","任务异常",0,"任务出现异常"),
    ;

    TaskProgressRateEnum(String key, String value, String label, Integer status, String showText) {
        this.key = key;
        this.value = value;
        this.label = label;
        this.status = status;
        this.showText = showText;
    }

    private String key ;
    private String value ;
    private String label ;
    private Integer status;
    private String showText ;



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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }

    public static TaskProgressRateEnum getByRateValue(Integer rate, boolean isException) {
        if(isException == true){
            return TaskProgressRateEnum.EXCEPTION ;
        }
        if(rate == 100) {
            return TaskProgressRateEnum.SUCCESS ;
        }   else {
            return TaskProgressRateEnum.DEFAULT ;
        }
    }

    public Map<String,Object> toMap() {
        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("key",this.key);
        map.put("value",this.value);
        map.put("label",this.label);
        map.put("status",this.status);
        map.put("showText",this.showText);
        return map ;
    }
}
