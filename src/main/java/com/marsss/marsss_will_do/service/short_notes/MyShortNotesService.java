package com.marsss.marsss_will_do.service.short_notes;

import com.marsss.marsss_will_do.bean.short_notes.MyShortNotesBean;
import com.marsss.marsss_will_do.common.base.service.MyBaseService;
import com.marsss.marsss_will_do.entity.short_notes.MyShortNotes;
import com.marsss.marsss_will_do.entity.user.UserAccount;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MyShortNotesService extends MyBaseService {

    /**
     * 新建
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    MyShortNotesBean doCreateMyShortNotes(HttpServletRequest request, MyShortNotes vo)  throws Exception;
    MyShortNotesBean doCreateMyShortNotes(HttpServletRequest request, MyShortNotesBean bean) throws Exception;

    /**
     * 更新
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    MyShortNotesBean doUpdateMyShortNotes(HttpServletRequest request,MyShortNotes vo) throws Exception ;
    MyShortNotesBean doUpdateMyShortNotes(HttpServletRequest request,MyShortNotesBean bean) throws Exception ;

    /**
     * 删除
     * @param request
     * @param activityProjectId
     */
    void doDeleteMyShortNotes(HttpServletRequest request,String activityProjectId) ;



    /**
     * 根据用户id查询 [便签]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    List<MyShortNotesBean> doGetMyShortNotesByUserAccount(HttpServletRequest request, UserAccount userAccount, String searchVal) throws Exception;
    /**
     * 根据id查询 [活动项目]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    MyShortNotesBean doGetMyShortNotesById(HttpServletRequest request, UserAccount userAccount,String projectId) throws Exception;
}
