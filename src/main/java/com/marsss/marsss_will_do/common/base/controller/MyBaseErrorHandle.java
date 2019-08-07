package com.marsss.marsss_will_do.common.base.controller;

import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.constant.MyBaseErrorResult;
import com.marsss.marsss_will_do.common.exception.user.UserAccountEmptyException;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyBaseErrorHandle {

    @ExceptionHandler(UserAccountEmptyException.class)
    @ResponseBody
    public MyBaseErrorResult emptyUserAccountException(UserAccountEmptyException e, HttpServletResponse response) {
        MyBaseErrorResult result = new MyBaseErrorResult() ;
        result.setInfo(e.getMessage());
        result.setHasError(true);
        result.setHasWarning(true);
        //权限问题拒绝
        result.setCode(403);
        return result ;
    }
}
