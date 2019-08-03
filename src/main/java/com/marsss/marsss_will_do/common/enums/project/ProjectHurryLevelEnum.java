package com.marsss.marsss_will_do.common.enums.project;

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
}
