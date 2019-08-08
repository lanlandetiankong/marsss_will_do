package com.marsss.marsss_will_do.service.projects;

<<<<<<< HEAD
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.repository.projects.ActivityProjectRepository;
import com.marsss.marsss_will_do.repository.projects.ArchiveProjectRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import org.hibernate.criterion.Example;
=======
import com.marsss.marsss_will_do.bean.project.ActivityProjectBean;
import com.marsss.marsss_will_do.bean.project.ActivityProjectBeanFormat;
import com.marsss.marsss_will_do.common.base.service.MyBaseServiceImpl;
import com.marsss.marsss_will_do.common.enums.project.ProjectStateEnum;
import com.marsss.marsss_will_do.common.exception.user.UserAccountEmptyException;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.projects.ActivityProjectRepository;
import com.marsss.marsss_will_do.repository.projects.ArchiveProjectRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.user.UserAccountService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.Example;
import org.owasp.esapi.User;
>>>>>>> temp
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
@Service
public class ActivityProjectServiceImpl implements ActivityProjectService {
=======
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityProjectServiceImpl extends MyBaseServiceImpl implements ActivityProjectService {
>>>>>>> temp
    private Logger logger = LoggerFactory.getLogger(ActivityProjectServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private ActivityProjectRepository activityProjectRepository ;
    @Autowired
    private ArchiveProjectRepository archiveProjectRepository ;
<<<<<<< HEAD


    @Override
    public void doGetActivityProjectByUserId(String userId) {

    }

    @Override
    public void doCreateActivityProject(ActivityProject activityProject) {

    }

    @Override
    public void doUpdateActivityProject(ActivityProject activityProject) {

    }

    @Override
    public void doDeleteActivityProject(String activityProjectId) {

    }

    @Override
    public void doBatchDeleteActivityProject(String activityProjectIds) {
=======
    @Autowired
    private UserAccountService userAccountService ;


    @Override
    public void doGetActivityProjectByUserId(HttpServletRequest request,String userId) {

    }
    @ApiOperation("Service:创建新项目,by Vo")
    @Override
    public ActivityProjectBean doCreateActivityProject(HttpServletRequest request,ActivityProject vo) throws Exception{
        vo.setState(ProjectStateEnum.ENABLED.getValue());
        vo.setUserAccount(userAccountService.requestGetUserAccount(request,true));
        vo = activityProjectRepository.save(vo) ;
        ActivityProjectBean bean = ActivityProjectBeanFormat.entityToBean(vo);
        return bean ;
    }
    @ApiOperation("Service:创建新项目,by Bean")
    @Override
    public ActivityProjectBean doCreateActivityProject(HttpServletRequest request,ActivityProjectBean bean) throws Exception{
        ActivityProject vo =  ActivityProjectBeanFormat.beanToEntity(bean) ;
        bean = doCreateActivityProject(request,vo) ;
        return bean ;
    }
    @ApiOperation("Service:更新新项目,by vo")
    @Override
    public ActivityProjectBean doUpdateActivityProject(HttpServletRequest request,ActivityProject vo) throws Exception{
        vo = activityProjectRepository.saveAndFlush(vo) ;
        ActivityProjectBean bean = ActivityProjectBeanFormat.entityToBean(vo);
        return bean ;
    }
    @ApiOperation("Service:更新新项目,by Bean")
    @Override
    public ActivityProjectBean doUpdateActivityProject(HttpServletRequest request,ActivityProjectBean bean) throws Exception{
        ActivityProject vo =  activityProjectRepository.findById(bean.getId()).get() ;
        vo = ActivityProjectBeanFormat.beanForUpdate(vo,bean);
        bean = doUpdateActivityProject(request,vo) ;
        return bean ;
    }



    @Override
    public void doDeleteActivityProject(HttpServletRequest request, String activityProjectId) {
        ActivityProject entity = activityProjectRepository.findById(activityProjectId).get();
        entity.setState(ProjectStateEnum.DELETE.getValue());
        activityProjectRepository.save(entity);
    }

    @Override
    public void doTranslateActivityProjectToArchiveById(HttpServletRequest request, String activityProjectId) throws Exception{
        ActivityProject entity = activityProjectRepository.findById(activityProjectId).get();
        ArchiveProject archiveProject = ActivityProjectBeanFormat.activityProjectTranslateToArchive(entity,null);
        archiveProject = archiveProjectRepository.save(archiveProject);
        entity.setIsTranslateArchive(1);
        entity.setArchiveProject(archiveProject);
        activityProjectRepository.save(entity);
    }



    @Override
    public List<ActivityProjectBean> doGetActivityProjectByUserAccount(HttpServletRequest request, UserAccount userAccount,String searchVal) throws Exception{
        List<ActivityProject> list = activityProjectRepository.getActivityProjectsByUserAccountId(userAccount.getId(),paramGetLikeStr(searchVal)) ;
        if(list == null) {
            return  null ;
        }   else {
            List<ActivityProjectBean> beanList = new ArrayList<ActivityProjectBean>() ;
            for(ActivityProject vo : list) {
                beanList.add(ActivityProjectBeanFormat.entityToBean(vo)) ;
            }
            return beanList ;
        }
    }

    /**
     * 根据id查询 [活动项目]
     *
     * @param request
     * @param userAccount
     * @param projectId
     * @return
     * @throws Exception
     */
    @Override
    public ActivityProjectBean doGetActivityProjectById(HttpServletRequest request, UserAccount userAccount, String projectId) throws Exception {
        ActivityProject vo =  activityProjectRepository.findById(projectId).get();
        if(vo == null) {
            return null ;
        }   else {
            return  ActivityProjectBeanFormat.entityToBean(vo);
        }
>>>>>>> temp
    }
}
