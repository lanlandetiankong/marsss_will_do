package com.marsss.marsss_will_do.common.enums.user;

public enum UserAccountBaseTypeEnum {
    SIMPLE_USER(1,"普通用户");

    UserAccountBaseTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private Integer value ;
    private String name ;

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
}
