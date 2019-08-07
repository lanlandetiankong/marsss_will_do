package com.marsss.marsss_will_do.common.constant;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyBaseCommonResult<T> implements Serializable {
    private String token ;
    //提示信息、错误信息等，用于展示
    private String info ;
    //传递到前端的 信息，用于使用
    private String msg ;
    private boolean hasError = false;
    private boolean hasWarning = false ;
    private boolean actionFlag = true ;
    //操作成功 的数量
    private long count ;
    //存储: 表格总数量
    private long total ;
    //域
    private String field;
    //跳转url
    private String backUrl ;
    //存储 表格数据
    private List rows ;
    private T bean;
    private Integer code;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    //存储 树集合
    private List resultList ;
    //存储 一些自定义属性的map集合
    private Map resultMap ;
    //存储 不重复的集合
    private Set resultSet ;

    private String[] errorArray ;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public String[] getErrorArray() {
        return errorArray;
    }

    public void setErrorArray(String[] errorArray) {
        this.errorArray = errorArray;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getResultList() {
        return resultList;
    }

    public void setResultList(List resultList) {
        this.resultList = resultList;
    }

    public String getInfo() {
        return info ;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Map getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map resultMap) {
        this.resultMap = resultMap;
    }

    public Set getResultSet() {
        return resultSet;
    }

    public void setResultSet(Set resultSet) {
        this.resultSet = resultSet;
    }

    public boolean isHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(boolean hasWarning) {
        this.hasWarning = hasWarning;
    }

    public boolean isActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(boolean actionFlag) {
        this.actionFlag = actionFlag;
    }
}
