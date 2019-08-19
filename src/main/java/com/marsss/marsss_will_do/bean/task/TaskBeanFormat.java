package com.marsss.marsss_will_do.bean.task;


import com.marsss.marsss_will_do.common.bean.BeanHelper;
import com.marsss.marsss_will_do.common.enums.task.TaskHurryLevelEnum;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.tasks.Task;
import com.marsss.marsss_will_do.repository.projects.ActivityProjectRepository;
import com.marsss.marsss_will_do.repository.projects.ArchiveProjectRepository;
import com.marsss.marsss_will_do.utils.date.MyDateUtil;
import com.mysql.cj.util.TestUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TaskBeanFormat {
    @Autowired
    private ActivityProjectRepository activityProjectRepository ;
    @Autowired
    private ArchiveProjectRepository archiveProjectRepository ;

    public static TaskBeanFormat taskBeanFormat;

    //工具类调用 @Repository
    @PostConstruct
    public void init() {
        taskBeanFormat = this;
    }

    public static TaskBean entityToBean(Task entity) throws Exception{
        try{
            TaskBean bean = new TaskBean() ;
            BeanUtils.copyProperties(bean,entity);
            BeanHelper.nullToEmpty(bean);
            ActivityProject activityProject = entity.getActivityProject();
            ArchiveProject archiveProject = entity.getArchiveProject();
            if(activityProject != null){
                bean.setActivityProjectId(activityProject.getId());
            }
            if(archiveProject != null){
                bean.setActivityProjectId(archiveProject.getId());
            }
            bean.setCreateDateVal(entity.getCreateDate());
            bean.setModifyDateVal(entity.getModifyDate());
            bean.setCreateDateStr(MyDateUtil.getDateTime(entity.getCreateDate()));
            bean.setModifyDateStr(MyDateUtil.getDateTime(entity.getModifyDate()));
            bean.setPlanStartDateStr(MyDateUtil.getDateTime(entity.getPlanStartDate()));
            bean.setPlanEndDateStr(MyDateUtil.getDateTime(entity.getPlanEndDate()));
            doSetVueElPropToBean(bean);
            return bean ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
    public static Task beanToEntity(TaskBean bean) throws Exception{
        try{
            Task entity = new Task() ;
            BeanUtils.copyProperties(entity,bean);
            String activityProjectId = bean.getActivityProjectId() ;
            String archiveProjectId = bean.getArchiveProjectId() ;
            if(StringUtils.isNotBlank(activityProjectId)){
                ActivityProject ac = taskBeanFormat.activityProjectRepository.findById(activityProjectId).get();
                entity.setActivityProject(ac);
            }
            if(StringUtils.isNotBlank(archiveProjectId)){
                entity.setArchiveProject(taskBeanFormat.archiveProjectRepository.findById(archiveProjectId).get());
            }
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    public static Task beanForUpdate(Task entity,TaskBean bean) throws Exception{
        try{
            BeanUtils.copyProperties(entity,bean);
            entity.setName(bean.getName());
            entity.setPlanStartDate(bean.getPlanStartDate());
            entity.setPlanEndDate(bean.getPlanEndDate());
            entity.setTaskLevel(bean.getTaskLevel());
            entity.setDescription(bean.getDescription());
            entity.setFirstNote(bean.getFirstNote());
            entity.setSecondNote(bean.getSecondNote());
            //entity.setSort(bean.getSort());
            entity.setRemark(bean.getRemark());
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }


    /**
     * 设置 Vue-Element 的一些属性到bean
     * @param bean
     */
    public static void doSetVueElPropToBean(TaskBean bean) {
        String taskLevel = bean.getTaskLevel() ;
        if(StringUtils.isNotBlank(taskLevel)){
            for(TaskHurryLevelEnum taskHurryLevelEnum : TaskHurryLevelEnum.values()){
                if(taskHurryLevelEnum.getValue().equals(taskLevel)){
                    bean.setVueElType(taskHurryLevelEnum.getType());
                    bean.setVueElIcon(taskHurryLevelEnum.getIcon());
                }
            }
        }
    }
}
