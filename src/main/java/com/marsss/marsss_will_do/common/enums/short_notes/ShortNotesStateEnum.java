package com.marsss.marsss_will_do.common.enums.short_notes;

public enum ShortNotesStateEnum {
    ENABLED(1,"启用","启用"),
    DISABLED(-1,"禁用","禁用"),
    DELETE(-2,"已删除","项目已删除")
            ;

    ShortNotesStateEnum(Integer value, String name, String info) {
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
