package com.marsss.marsss_will_do.bean.tags;

import com.marsss.marsss_will_do.common.enums.tags.TagsHurryLevelEnum;
import com.marsss.marsss_will_do.entity.tags.MyTags;
import org.apache.commons.beanutils.BeanUtils;

public class MyTagsBeanFormat {

    public static MyTagsBean entityToBean(MyTags entity) throws Exception{
        try{
            MyTagsBean bean = new MyTagsBean() ;
            BeanUtils.copyProperties(bean,entity);
            bean.setHurryLevelShow(TagsHurryLevelEnum.getEnumShowStr(bean.getHurryLevel()));
            return bean ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
    public static MyTags beanToEntity(MyTagsBean bean) throws Exception{
        try{
            MyTags entity = new MyTags() ;
            BeanUtils.copyProperties(entity,bean);
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    public static MyTags beanForUpdate(MyTags entity,MyTagsBean bean) throws Exception{
        try{
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
}
