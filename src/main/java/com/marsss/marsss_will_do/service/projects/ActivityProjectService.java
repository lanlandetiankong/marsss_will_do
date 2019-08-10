package com.marsss.marsss_will_do.service.projects;

import com.marsss.marsss_will_do.bean.project.ActivityProjectBean;
import com.marsss.marsss_will_do.common.base.service.MyBaseService;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.user.UserAccount;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ActivityProjectService extends MyBaseService {

    /**
     * 新建
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    ActivityProjectBean doCreateActivityProject(HttpServletRequest request, ActivityProject vo)  throws Exception;
    ActivityProjectBean doCreateActivityProject(HttpServletRequest request,ActivityProjectBean bean) throws Exception;

    /**
     * 更新
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    ActivityProjectBean doUpdateActivityProject(HttpServletRequest request,ActivityProject vo) throws Exception ;
    ActivityProjectBean doUpdateActivityProject(HttpServletRequest request,ActivityProjectBean bean) throws Exception ;

    /**
     * 删除
     * @param request
     * @param activityProjectId
     */
    void doDeleteActivityProject(HttpServletRequest request,String activityProjectId) ;

    /**
     * 项目归档
     * @param request
     * @param activityProjectId
     */
    void doTranslateActivityProjectToArchiveById(HttpServletRequest request, String activityProjectId) throws Exception;


    /**
     * 根据用户id查询 [活动项目]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    List<ActivityProjectBean> doGetActivityProjectByUserAccount(HttpServletRequest request, UserAccount userAccount, String searchVal) throws Exception;
    /**
     * 根据id查询 [活动项目]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    ActivityProjectBean doGetActivityProjectById(HttpServletRequest request, UserAccount userAccount,String projectId) throws Exception;
}
