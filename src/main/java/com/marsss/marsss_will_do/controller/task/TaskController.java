package com.marsss.marsss_will_do.controller.task;

import com.marsss.marsss_will_do.bean.task.TaskBean;
import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.exception.result.NullResultBeanException;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.service.tasks.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/apis/task")
public class TaskController extends MyBaseController{
    @Autowired
   private TaskService taskService ;



    @ApiOperation(value = "创建任务",notes = "创建任务")
    @PostMapping("/add/task")
    public MyBaseCommonResult doAddTask(HttpServletRequest request, TaskBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            TaskBean resultBean = taskService.doCreateTask(request,bean) ;
            result.setBean(resultBean);
            result.setInfo("成功创建任务");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("创建任务失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
    @ApiOperation(value = "更新任务",notes = "更新任务")
    @PostMapping("/update/task")
    public MyBaseCommonResult doUpdateTask(HttpServletRequest request, TaskBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            TaskBean resultBean = taskService.doUpdateTask(request,bean) ;
            result.setBean(resultBean);
            result.setInfo("更新任务成功!");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("更新任务失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "取得用户的[任务]",notes = "根据token取得用户的[任务]")
    @PostMapping("/get/all/task")
    public MyBaseCommonResult doGetTaskByTokenId(HttpServletRequest request,String searchVal) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            List<TaskBean> beanList = taskService.doGetTaskByUserAccount(request,userAccount,searchVal);
            if(beanList == null){
                result.setCount(0);
            }   else {
                result.setResultList(beanList);
                result.setCount(beanList.size());
            }
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("取得任务失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }


    @ApiOperation(value = "查询指定[任务]",notes = "根据TaskId取得[任务]")
    @PostMapping("/get/task/by_id")
    public MyBaseCommonResult doGetTaskVoById(HttpServletRequest request,String taskId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            TaskBean bean = taskService.doGetTaskById(request,userAccount,taskId);
            if(bean == null) {
                throw new NullResultBeanException() ;
            }
            result.setBean(bean);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("查询指定[任务]失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
    @ApiOperation(value = "删除指定[任务]",notes = "根据TaskId删除[任务]")
    @PostMapping("/delete/task/by_id")
    public MyBaseCommonResult doDeleteTaskVoById(HttpServletRequest request, String taskId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            taskService.doDeleteTask(request,taskId);
            result.setInfo("成功删除任务！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("删除指定[任务]失败!"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }


}
