package com.marsss.marsss_will_do.bean.project;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.utils.pinyin.MyPinYinUtil;
import org.apache.commons.beanutils.BeanUtils;

public class ActivityProjectBeanFormat {
    public static ActivityProjectBean entityToBean(ActivityProject entity) throws Exception{
        try{
            ActivityProjectBean bean = new ActivityProjectBean() ;
            BeanUtils.copyProperties(bean,entity);
            return bean ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
    public static ActivityProject beanToEntity(ActivityProjectBean bean) throws Exception{
        try{
            ActivityProject entity = new ActivityProject() ;
            BeanUtils.copyProperties(entity,bean);
            entity.setCode(MyPinYinUtil.toPinyin(entity.getName()));
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    public static ActivityProject beanForUpdate(ActivityProject entity,ActivityProjectBean bean) throws Exception{
        try{
            BeanUtils.copyProperties(entity,bean);
            entity.setName(bean.getName());
            entity.setCode(MyPinYinUtil.toPinyin(entity.getName()));
            entity.setStartDate(bean.getStartDate());
            entity.setEndDate(bean.getEndDate());
            entity.setHurryLevel(bean.getHurryLevel());
            entity.setGoal(bean.getGoal());
            entity.setDescription(bean.getDescription());
            entity.setFirstNote(bean.getFirstNote());
            entity.setSecondNote(bean.getSecondNote());
            entity.setSort(bean.getSort());
            entity.setRemark(bean.getRemark());
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * 活动项目 转 归档项目
     * @param activityProject
     * @param archiveProject
     * @return
     * @throws Exception
     */
    public static ArchiveProject activityProjectTranslateToArchive(ActivityProject activityProject,ArchiveProject archiveProject) throws Exception{
        try{
            archiveProject = archiveProject != null ? archiveProject : new ArchiveProject() ;
            BeanUtils.copyProperties(archiveProject,activityProject);
            archiveProject.setName(activityProject.getName());
            archiveProject.setCode(MyPinYinUtil.toPinyin(activityProject.getName()));
            archiveProject.setStartDate(activityProject.getStartDate());
            archiveProject.setEndDate(activityProject.getEndDate());
            archiveProject.setHurryLevel(activityProject.getHurryLevel());
            archiveProject.setGoal(activityProject.getGoal());
            archiveProject.setDescription(activityProject.getDescription());
            archiveProject.setFirstNote(activityProject.getFirstNote());
            archiveProject.setSecondNote(activityProject.getSecondNote());
            archiveProject.setSort(activityProject.getSort());
            archiveProject.setRemark(activityProject.getRemark());
            archiveProject.setActivityProject(activityProject);
            return archiveProject ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
}
