package com.marsss.marsss_will_do.service.projects;

<<<<<<< HEAD
public interface ArchiveProjectService {
=======
import com.marsss.marsss_will_do.bean.project.ArchiveProjectBean;
import com.marsss.marsss_will_do.common.base.service.MyBaseService;
import com.marsss.marsss_will_do.entity.user.UserAccount;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ArchiveProjectService extends MyBaseService{


    /**
     * 根据用户id查询 [归档项目]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    List<ArchiveProjectBean> doGetArchiveProjectByUserAccount(HttpServletRequest request, UserAccount userAccount,String searchVal) throws Exception;
    /**
     * 根据id查询 [归档项目]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    ArchiveProjectBean doGetArchiveProjectById(HttpServletRequest request, UserAccount userAccount,String projectId) throws Exception;


    /**
     * 删除 [归档项目]
     * @param request
     * @param activityProjectId
     */
    void doDeleteArchiveProject(HttpServletRequest request,String activityProjectId) ;
>>>>>>> temp
}
