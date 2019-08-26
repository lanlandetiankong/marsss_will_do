package com.marsss.marsss_will_do.utils.str;

import org.apache.commons.lang.StringUtils;

public class MyStringUtil {

    /**
     * 判断是否所有 字符串都非空白
     * @param strs
     * @return
     */
    public static boolean doCheckIsAllNotBlank(String... strs) {
        boolean flag = true ;
        for(String str : strs){
            if (StringUtils.isBlank(str)){
                flag = false;
                break;
            }
        }
        return flag ;
    }
}
