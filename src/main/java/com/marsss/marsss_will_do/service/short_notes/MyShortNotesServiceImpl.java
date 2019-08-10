package com.marsss.marsss_will_do.service.short_notes;

import com.marsss.marsss_will_do.bean.short_notes.MyShortNotesBean;
import com.marsss.marsss_will_do.bean.short_notes.MyShortNotesBeanFormat;
import com.marsss.marsss_will_do.common.base.service.MyBaseServiceImpl;
import com.marsss.marsss_will_do.common.enums.project.ProjectStateEnum;
import com.marsss.marsss_will_do.common.enums.short_notes.ShortNotesStateEnum;
import com.marsss.marsss_will_do.entity.short_notes.MyShortNotes;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.short_notes.MyShortNoteRepository;
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
public class MyShortNotesServiceImpl extends MyBaseServiceImpl implements MyShortNotesService {
    private Logger logger = LoggerFactory.getLogger(MyShortNotesServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private MyShortNoteRepository myShortNoteRepository ;

    @Autowired
    private UserAccountService userAccountService ;


    /**
     * 新建
     *
     * @param request
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public MyShortNotesBean doCreateMyShortNotes(HttpServletRequest request, MyShortNotes vo) throws Exception {
        vo.setState(ShortNotesStateEnum.ENABLED.getValue());
        vo.setUserAccount(userAccountService.requestGetUserAccount(request,true));
        vo = myShortNoteRepository.save(vo) ;
        MyShortNotesBean bean = MyShortNotesBeanFormat.entityToBean(vo);
        return bean ;
    }

    @Override
    public MyShortNotesBean doCreateMyShortNotes(HttpServletRequest request, MyShortNotesBean bean) throws Exception {
        MyShortNotes vo =  MyShortNotesBeanFormat.beanToEntity(bean) ;
        bean = doCreateMyShortNotes(request,vo) ;
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
    public MyShortNotesBean doUpdateMyShortNotes(HttpServletRequest request, MyShortNotes vo) throws Exception {
        vo = myShortNoteRepository.saveAndFlush(vo) ;
        MyShortNotesBean bean = MyShortNotesBeanFormat.entityToBean(vo);
        return bean ;
    }

    @Override
    public MyShortNotesBean doUpdateMyShortNotes(HttpServletRequest request, MyShortNotesBean bean) throws Exception {
        MyShortNotes vo =  myShortNoteRepository.findById(bean.getId()).get() ;
        vo = MyShortNotesBeanFormat.beanForUpdate(vo,bean);
        bean = doUpdateMyShortNotes(request,vo) ;
        return bean ;
    }

    /**
     * 删除
     *
     * @param request
     * @param activityProjectId
     */
    @Override
    public void doDeleteMyShortNotes(HttpServletRequest request, String activityProjectId) {
        MyShortNotes entity = myShortNoteRepository.findById(activityProjectId).get();
        entity.setState(ProjectStateEnum.DELETE.getValue());
        myShortNoteRepository.save(entity);
    }

    /**
     * 根据用户id查询 [活动项目]
     *
     * @param request
     * @param userAccount
     * @param searchVal
     * @return
     * @throws Exception
     */
    @Override
    public List<MyShortNotesBean> doGetMyShortNotesByUserAccount(HttpServletRequest request, UserAccount userAccount, String searchVal) throws Exception {
        List<MyShortNotes> list = myShortNoteRepository.getMyShortNotesByUserAccountId(userAccount.getId(),paramGetLikeStr(searchVal)) ;
        if(list == null) {
            return  null ;
        }   else {
            List<MyShortNotesBean> beanList = new ArrayList<MyShortNotesBean>() ;
            for(MyShortNotes vo : list) {
                beanList.add(MyShortNotesBeanFormat.entityToBean(vo)) ;
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
    public MyShortNotesBean doGetMyShortNotesById(HttpServletRequest request, UserAccount userAccount, String shortNoteId) throws Exception {
        MyShortNotes vo =  myShortNoteRepository.findById(shortNoteId).get();
        if(vo == null) {
            return null ;
        }   else {
            return  MyShortNotesBeanFormat.entityToBean(vo);
        }
    }
}
