package com.marsss.marsss_will_do.service.tags;

import com.marsss.marsss_will_do.bean.tags.MyTagsBean;
import com.marsss.marsss_will_do.common.base.service.MyBaseService;
import com.marsss.marsss_will_do.entity.tags.MyTags;
import com.marsss.marsss_will_do.entity.user.UserAccount;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MyTagsService extends MyBaseService{

    /**
     * 新建
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    MyTagsBean doCreateMyTags(HttpServletRequest request, MyTags vo)  throws Exception;
    MyTagsBean doCreateMyTags(HttpServletRequest request, MyTagsBean bean) throws Exception;

    /**
     * 更新
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    MyTagsBean doUpdateMyTags(HttpServletRequest request, MyTags vo) throws Exception ;
    MyTagsBean doUpdateMyTags(HttpServletRequest request,MyTagsBean bean) throws Exception ;

    /**
     * 删除
     * @param request
     * @param activityProjectId
     */
    void doDeleteMyTags(HttpServletRequest request,String activityProjectId) ;



    /**
     * 根据用户id查询 [活动项目]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    List<MyTagsBean> doGetMyTagsByUserAccount(HttpServletRequest request, UserAccount userAccount, String searchVal) throws Exception;
    /**
     * 根据id查询 [活动项目]
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    MyTagsBean doGetMyTagsById(HttpServletRequest request, UserAccount userAccount,String projectId) throws Exception;
}
