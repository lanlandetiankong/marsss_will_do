package com.marsss.marsss_will_do.controller.project;

import com.marsss.marsss_will_do.bean.project.ActivityProjectBean;
import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.exception.result.NullResultBeanException;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.service.projects.ActivityProjectService;
import com.marsss.marsss_will_do.service.projects.ArchiveProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/apis/project/activity")
public class ActivityProjectController extends MyBaseController{
    @Autowired
    private ActivityProjectService activityProjectService ;
    @Autowired
    private ArchiveProjectService archiveProjectService ;


    @ApiOperation(value = "创建活动项目",notes = "创建活动项目")
    @PostMapping("/add/activity_project")
    public MyBaseCommonResult doAddActivityProject(HttpServletRequest request, ActivityProjectBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            ActivityProjectBean resultBean = activityProjectService.doCreateActivityProject(request,bean) ;
            result.setBean(resultBean);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("创建活动项目失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
    @ApiOperation(value = "更新活动项目",notes = "更新活动项目")
    @PostMapping("/update/activity_project")
    public MyBaseCommonResult doUpdateActivityProject(HttpServletRequest request, ActivityProjectBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            ActivityProjectBean resultBean = activityProjectService.doUpdateActivityProject(request,bean) ;
            result.setBean(resultBean);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("更新活动项目失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "取得用户的[活动项目]",notes = "根据token取得用户的[活动项目]")
    @PostMapping("/get_activity_project")
    public MyBaseCommonResult doGetActivityProjectByTokenId(HttpServletRequest request,String searchVal) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            List<ActivityProjectBean> beanList = activityProjectService.doGetActivityProjectByUserAccount(request,userAccount,searchVal);
            if(beanList == null){
                result.setCount(0);
            }   else {
                result.setResultList(beanList);
                result.setCount(beanList.size());
            }
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("取得活动项目失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }


    @ApiOperation(value = "查询指定[活动项目]",notes = "根据ProjectId取得[活动项目]")
    @PostMapping("/get/activity_project/by_id")
    public MyBaseCommonResult doGetActivityProjectVoById(HttpServletRequest request,String projectId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            ActivityProjectBean bean = activityProjectService.doGetActivityProjectById(request,userAccount,projectId);
            if(bean == null) {
                throw new NullResultBeanException() ;
            }
            result.setBean(bean);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("查询指定[活动项目]失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
    @ApiOperation(value = "删除指定[活动项目]",notes = "根据ProjectId删除[活动项目]")
    @PostMapping("/delete/activity_project/by_id")
    public MyBaseCommonResult doDeleteActivityProjectVoById(HttpServletRequest request,String projectId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            activityProjectService.doDeleteActivityProject(request,projectId);
            result.setInfo("删除成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("删除指定[活动项目]失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
    @ApiOperation(value = "归档[活动项目]",notes = "根据ProjectId归档[活动项目]")
    @PostMapping("/translate/activity_project/to_archive_project/by_id")
    public MyBaseCommonResult doTranslateActivityProjectToArchiveById(HttpServletRequest request,String projectId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            activityProjectService.doTranslateActivityProjectToArchiveById(request,projectId);
            result.setInfo("归档成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("归档指定[活动项目]失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
}
