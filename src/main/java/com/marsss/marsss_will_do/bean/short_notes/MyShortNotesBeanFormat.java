package com.marsss.marsss_will_do.bean.short_notes;

import com.marsss.marsss_will_do.entity.short_notes.MyShortNotes;
import com.marsss.marsss_will_do.utils.date.MyDateStyle;
import com.marsss.marsss_will_do.utils.date.MyDateUtil;
import org.apache.commons.beanutils.BeanUtils;

public class MyShortNotesBeanFormat {

    public static MyShortNotesBean entityToBean(MyShortNotes entity) throws Exception{
        try{
            MyShortNotesBean bean = new MyShortNotesBean() ;
            BeanUtils.copyProperties(bean,entity);
            bean.setCreateDateStr(MyDateUtil.DateToString(entity.getCreateDate(), MyDateStyle.YYYY_MM_DD_HH_MM_SS_CN));
            bean.setModifyDateStr(MyDateUtil.DateToString(entity.getModifyDate(), MyDateStyle.YYYY_MM_DD_HH_MM_SS_CN));
            return bean ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }
    public static MyShortNotes beanToEntity(MyShortNotesBean bean) throws Exception{
        try{
            MyShortNotes entity = new MyShortNotes() ;
            BeanUtils.copyProperties(entity,bean);
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    public static MyShortNotes beanForUpdate(MyShortNotes entity,MyShortNotesBean bean) throws Exception{
        try{
            entity.setContent(bean.getContent());
            return entity ;
        }   catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

}
