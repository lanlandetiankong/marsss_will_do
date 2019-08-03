package com.marsss.marsss_will_do.common.constant;

/**
 * 返回页面显示的一些常量定义
 */
public interface MyCommonResultConstant {
    static final String FAILED = "操作失败！" ;
    static final String SUCCESS = "操作成功！" ;
    String SET_FAILED_REASON = "操作失败！可能的失败原因:";
    static final String INVALID_LENGTH = "无效长度！" ;
    static final String EMPTY_USERNAME = "用户名不能为空！" ;
    static final String EMPTY_PASSWORD =  "密码不能为空！" ;
    static final String INVALID_USERNAME = "帐号不存在！" ;
    static final String INVALID_PASSWORD = "密码错误！" ;
    static final String INVALID_ACCOUNT = "无效帐号！" ;
    static final String HAS_ENABLED = "无法删除已启用的项！请先对该项进行禁用！" ;
    static final String EXISTING_YUN_URL = "已存在的私有云或公有云！" ;
    static final String RESOURCES_HAVE_BEEN_REFERENCED = "资源已被引用！" ;
    static final String UNIQUE_FIELD_NOT_ALLOW_REPEAT = "插入的值在数据库中不允许重复！" ;

}
