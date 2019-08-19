package com.marsss.marsss_will_do.service.tasks;

import com.marsss.marsss_will_do.bean.task.TaskBean;
import com.marsss.marsss_will_do.bean.task.TaskBeanFormat;
import com.marsss.marsss_will_do.common.base.service.MyBaseServiceImpl;
import com.marsss.marsss_will_do.common.enums.task.TaskStateEnum;
import com.marsss.marsss_will_do.entity.tasks.Task;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.tasks.TaskRepository;
import com.marsss.marsss_will_do.service.user.UserAccountService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl extends MyBaseServiceImpl implements TaskService{
    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    @Autowired
    private TaskRepository taskRepository ;
    @Autowired
    private UserAccountService userAccountService ;



    @ApiOperation("Service:创建新任务,by Vo")
    @Override
    public TaskBean doCreateTask(HttpServletRequest request, Task vo) throws Exception{
        vo.setState(TaskStateEnum.ENABLED.getValue());
        vo.setUserAccount(userAccountService.requestGetUserAccount(request,true));
        vo = taskRepository.save(vo) ;
        TaskBean bean = TaskBeanFormat.entityToBean(vo);
        return bean ;
    }
    @ApiOperation("Service:创建新任务,by Bean")
    @Override
    public TaskBean doCreateTask(HttpServletRequest request,TaskBean bean) throws Exception{
        Task vo =  TaskBeanFormat.beanToEntity(bean) ;
        bean = doCreateTask(request,vo) ;
        return bean ;
    }
    @ApiOperation("Service:更新新任务,by vo")
    @Override
    public TaskBean doUpdateTask(HttpServletRequest request,Task vo) throws Exception{
        vo = taskRepository.saveAndFlush(vo) ;
        TaskBean bean = TaskBeanFormat.entityToBean(vo);
        return bean ;
    }
    @ApiOperation("Service:更新新任务,by Bean")
    @Override
    public TaskBean doUpdateTask(HttpServletRequest request,TaskBean bean) throws Exception{
        Task vo =  taskRepository.findById(bean.getId()).get() ;
        vo = TaskBeanFormat.beanForUpdate(vo,bean);
        bean = doUpdateTask(request,vo) ;
        return bean ;
    }



    @Override
    public void doDeleteTask(HttpServletRequest request, String taskId) {
        Task entity = taskRepository.findById(taskId).get();
        entity.setState(TaskStateEnum.DELETE.getValue());
        taskRepository.save(entity);
    }



    @Override
    public List<TaskBean> doGetTaskByUserAccount(HttpServletRequest request, UserAccount userAccount,String searchVal) throws Exception{
        List<Task> list = taskRepository.getTasksByUserAccountId(userAccount.getId(),paramGetLikeStr(searchVal)) ;
        if(list == null) {
            return  null ;
        }   else {
            List<TaskBean> beanList = new ArrayList<TaskBean>() ;
            for(Task vo : list) {
                beanList.add(TaskBeanFormat.entityToBean(vo)) ;
            }
            return beanList ;
        }
    }

    /**
     * 根据id查询 [活动任务]
     *
     * @param request
     * @param userAccount
     * @param taskId
     * @return
     * @throws Exception
     */
    @Override
    public TaskBean doGetTaskById(HttpServletRequest request, UserAccount userAccount, String taskId) throws Exception {
        Task vo =  taskRepository.findById(taskId).get();
        if(vo == null) {
            return null ;
        }   else {
            return  TaskBeanFormat.entityToBean(vo);
        }
    }

}
