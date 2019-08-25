package com.marsss.marsss_will_do.bean.user;

import com.marsss.marsss_will_do.bean.project.ArchiveProjectBean;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.utils.pinyin.MyPinYinUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserAccountBeanFormat {

    public static UserAccountBean entityToBean(UserAccount entity) throws Exception{
        try{
            UserAccountBean bean = new UserAccountBean() ;
            BeanUtils.copyProperties(bean,entity);
            if(entity.getUserAccountInfo() != null) {
                bean.setUserAccountInfoId(entity.getUserAccountInfo().getId());
            }
            return bean ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
    public static UserAccount beanToEntity(UserAccountBean bean) throws Exception{
        try{
            UserAccount entity = new UserAccount() ;
            BeanUtils.copyProperties(entity,bean);
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
}
