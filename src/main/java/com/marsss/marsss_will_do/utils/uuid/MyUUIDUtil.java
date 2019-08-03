package com.marsss.marsss_will_do.utils.uuid;

import java.util.UUID;

public class MyUUIDUtil {

    public static String renderSimpleUUID() {
        return UUID.randomUUID().toString().replace("-","") ;
    }
}
