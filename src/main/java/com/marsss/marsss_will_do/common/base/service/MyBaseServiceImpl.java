package com.marsss.marsss_will_do.common.base.service;

import org.apache.commons.lang.StringUtils;

public class MyBaseServiceImpl {



    public String  paramGetLikeStr(String param) {
        if(StringUtils.isBlank(param)) {
            return "%%" ;
        }
        return "%" + param + "%" ;
    }
}
