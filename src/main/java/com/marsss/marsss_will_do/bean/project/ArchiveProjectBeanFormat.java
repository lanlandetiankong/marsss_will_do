package com.marsss.marsss_will_do.bean.project;

import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.utils.pinyin.MyPinYinUtil;
import org.apache.commons.beanutils.BeanUtils;

public class ArchiveProjectBeanFormat {

    public static ArchiveProjectBean entityToBean(ArchiveProject entity) throws Exception{
        try{
            ArchiveProjectBean bean = new ArchiveProjectBean() ;
            BeanUtils.copyProperties(bean,entity);
            return bean ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
    public static ArchiveProject beanToEntity(ArchiveProjectBean bean) throws Exception{
        try{
            ArchiveProject entity = new ArchiveProject() ;
            BeanUtils.copyProperties(entity,bean);
            entity.setCode(MyPinYinUtil.toPinyin(entity.getName()));
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    public static ArchiveProject beanForUpdate(ArchiveProject entity,ArchiveProjectBean bean) throws Exception{
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

}
