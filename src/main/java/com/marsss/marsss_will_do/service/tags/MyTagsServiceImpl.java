package com.marsss.marsss_will_do.service.tags;

import com.marsss.marsss_will_do.bean.tags.MyTagsBean;
import com.marsss.marsss_will_do.bean.tags.MyTagsBeanFormat;
import com.marsss.marsss_will_do.common.base.service.MyBaseServiceImpl;
import com.marsss.marsss_will_do.common.enums.project.ProjectStateEnum;
import com.marsss.marsss_will_do.common.enums.tags.TagsStateEnum;
import com.marsss.marsss_will_do.entity.tags.MyTags;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.tags.MyTagRepository;
import com.marsss.marsss_will_do.repository.tags.TaskTagRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.user.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyTagsServiceImpl extends MyBaseServiceImpl implements MyTagsService {
    private Logger logger = LoggerFactory.getLogger(MyTagsServiceImpl.class);
    
    @Autowired
    private UserAccountService userAccountService;
    
    @Autowired
    private UserAccountRepository userAccountRepository ;

    @Autowired
    private MyTagRepository myTagRepository ;
    @Autowired
    private TaskTagRepository taskTagRepository ;


    /**
     * 新建
     *
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public MyTagsBean doCreateMyTags(HttpServletRequest request, MyTags vo) throws Exception {
        vo.setState(TagsStateEnum.ENABLED.getValue());
        vo.setUserAccount(userAccountService.requestGetUserAccount(request,true));
        vo = myTagRepository.save(vo) ;
        MyTagsBean bean = MyTagsBeanFormat.entityToBean(vo);
        return bean ;
    }

    @Override
    public MyTagsBean doCreateMyTags(HttpServletRequest request, MyTagsBean bean) throws Exception {
        MyTags vo =  MyTagsBeanFormat.beanToEntity(bean) ;
        bean = doCreateMyTags(request,vo) ;
        return bean ;
    }

    /**
     * 更新
     *
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public MyTagsBean doUpdateMyTags(HttpServletRequest request, MyTags vo) throws Exception {
        vo = myTagRepository.saveAndFlush(vo) ;
        MyTagsBean bean = MyTagsBeanFormat.entityToBean(vo);
        return bean ;
    }

    @Override
    public MyTagsBean doUpdateMyTags(HttpServletRequest request, MyTagsBean bean) throws Exception {
        MyTags vo =  myTagRepository.findById(bean.getId()).get() ;
        vo = MyTagsBeanFormat.beanForUpdate(vo,bean);
        bean = doUpdateMyTags(request,vo) ;
        return bean ;
    }

    /**
     * 删除
     *
     * @param request
     * @param activityProjectId
     */
    @Override
    public void doDeleteMyTags(HttpServletRequest request, String activityProjectId) {
        MyTags entity = myTagRepository.findById(activityProjectId).get();
        entity.setState(ProjectStateEnum.DELETE.getValue());
        myTagRepository.save(entity);
    }

    /**
     * 根据用户id查询 [便签]
     *
     * @param request
     * @param userAccount
     * @param searchVal
     * @return
     * @throws Exception
     */
    @Override
    public List<MyTagsBean> doGetMyTagsByUserAccount(HttpServletRequest request, UserAccount userAccount, String searchVal) throws Exception {
        List<MyTags> list = myTagRepository.getMyTagsByUserAccountId(userAccount.getId(),paramGetLikeStr(searchVal)) ;
        if(list == null) {
            return  null ;
        }   else {
            List<MyTagsBean> beanList = new ArrayList<MyTagsBean>() ;
            for(MyTags vo : list) {
                beanList.add(MyTagsBeanFormat.entityToBean(vo)) ;
            }
            return beanList ;
        }
    }

    /**
     * 根据id查询 [活动项目]
     *
     * @param request
     * @param userAccount
     * @param shortNoteId
     * @return
     * @throws Exception
     */
    @Override
    public MyTagsBean doGetMyTagsById(HttpServletRequest request, UserAccount userAccount, String shortNoteId) throws Exception {
        MyTags vo =  myTagRepository.findById(shortNoteId).get();
        if(vo == null) {
            return null ;
        }   else {
            return  MyTagsBeanFormat.entityToBean(vo);
        }
    }
}
