package com.marsss.marsss_will_do.common.constant;

import java.util.List;
import java.util.Map;

public class MyEnumResult {
    private List<Map<String,Object>> enumList;
    private Integer size ;

    public List<Map<String, Object>> getEnumList() {
        return enumList;
    }

    public void setEnumList(List<Map<String, Object>> enumList) {
        this.enumList = enumList;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
