package com.marsss.marsss_will_do.controller.project;

import com.marsss.marsss_will_do.bean.project.ArchiveProjectBean;
import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.exception.result.NullResultBeanException;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.service.projects.ActivityProjectService;
import com.marsss.marsss_will_do.service.projects.ArchiveProjectService;
import com.marsss.marsss_will_do.service.projects.ArchiveProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/apis/project/archive")
public class ArchiveProjectController extends MyBaseController{
    @Autowired
    private ArchiveProjectService archiveProjectService ;
    @Autowired
    private ActivityProjectService activityProjectService ;


    @ApiOperation(value = "取得用户的[归档项目]",notes = "根据token取得用户的[归档项目]")
    @PostMapping("/get_archive_project")
    public MyBaseCommonResult doGetArchiveProjectByTokenId(HttpServletRequest request,String searchVal) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            List<ArchiveProjectBean> beanList = archiveProjectService.doGetArchiveProjectByUserAccount(request,userAccount,searchVal);
            if(beanList == null){
                result.setCount(0);
            }   else {
                result.setResultList(beanList);
                result.setCount(beanList.size());
            }
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("取得归档项目失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }


    @ApiOperation(value = "查询指定[归档项目]",notes = "根据ProjectId取得[归档项目]")
    @PostMapping("/get/archive_project/by_id")
    public MyBaseCommonResult doGetArchiveProjectVoById(HttpServletRequest request,String projectId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            ArchiveProjectBean bean = archiveProjectService.doGetArchiveProjectById(request,userAccount,projectId);
            if(bean == null) {
                throw new NullResultBeanException() ;
            }
            result.setBean(bean);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("查询指定[归档项目]失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
    @ApiOperation(value = "删除指定[归档项目]",notes = "根据ProjectId删除[归档项目]")
    @PostMapping("/delete/archive_project/by_id")
    public MyBaseCommonResult doDeleteArchiveProjectVoById(HttpServletRequest request,String projectId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            archiveProjectService.doDeleteArchiveProject(request,projectId);
            result.setInfo("删除成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("删除指定[归档项目]失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

}
