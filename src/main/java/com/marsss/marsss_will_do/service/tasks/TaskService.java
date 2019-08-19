package com.marsss.marsss_will_do.service.tasks;

import com.marsss.marsss_will_do.bean.task.TaskBean;
import com.marsss.marsss_will_do.common.base.service.MyBaseService;
import com.marsss.marsss_will_do.entity.tasks.Task;
import com.marsss.marsss_will_do.entity.user.UserAccount;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TaskService extends MyBaseService{

    /**
     * 新建
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    TaskBean doCreateTask(HttpServletRequest request, Task vo)  throws Exception;
    TaskBean doCreateTask(HttpServletRequest request,TaskBean bean) throws Exception;

    /**
     * 更新
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    TaskBean doUpdateTask(HttpServletRequest request,Task vo) throws Exception ;
    TaskBean doUpdateTask(HttpServletRequest request,TaskBean bean) throws Exception ;

    /**
     * 删除
     * @param request
     * @param taskId
     */
    void doDeleteTask(HttpServletRequest request,String taskId) ;


    /**
     * 根据用户id查询 [任务]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    List<TaskBean> doGetTaskByUserAccount(HttpServletRequest request, UserAccount userAccount, String searchVal) throws Exception;
    /**
     * 根据id查询 [任务]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    TaskBean doGetTaskById(HttpServletRequest request, UserAccount userAccount,String taskId) throws Exception;

}
