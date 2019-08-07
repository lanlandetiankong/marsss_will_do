package com.marsss.marsss_will_do.common.constant;

import java.util.List;

public class MyBaseErrorResult {
    //提示信息、错误信息等，用于展示
    private String info ;
    //传递到前端的 信息，用于使用
    private String msg ;
    private boolean hasError = false;
    private boolean hasWarning = false ;
    private boolean actionFlag = true ;
    //跳转url
    private String backUrl ;
    private Integer code;


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
