package com.marsss.marsss_will_do.service.projects;

<<<<<<< HEAD
=======
import com.marsss.marsss_will_do.bean.project.ActivityProjectBean;
import com.marsss.marsss_will_do.bean.project.ActivityProjectBeanFormat;
import com.marsss.marsss_will_do.bean.project.ArchiveProjectBean;
import com.marsss.marsss_will_do.bean.project.ArchiveProjectBeanFormat;
import com.marsss.marsss_will_do.common.base.service.MyBaseServiceImpl;
import com.marsss.marsss_will_do.common.enums.project.ProjectStateEnum;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccount;
>>>>>>> temp
import com.marsss.marsss_will_do.repository.projects.ActivityProjectRepository;
import com.marsss.marsss_will_do.repository.projects.ArchiveProjectRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.short_notes.ShortNoteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
@Service
public class ArchiveProjectServiceImpl implements ArchiveProjectService {
=======
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchiveProjectServiceImpl extends MyBaseServiceImpl implements ArchiveProjectService {
>>>>>>> temp
    private Logger logger = LoggerFactory.getLogger(ArchiveProjectServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private ActivityProjectRepository activityProjectRepository ;
    @Autowired
    private ArchiveProjectRepository archiveProjectRepository ;


<<<<<<< HEAD



=======
    /**
     * 根据用户id查询 [归档项目]
     *
     * @param request
     * @param userAccount
     * @return
     * @throws Exception
     */
    @Override
    public List<ArchiveProjectBean> doGetArchiveProjectByUserAccount(HttpServletRequest request, UserAccount userAccount,String searchVal) throws Exception {
        List<ArchiveProject> list = archiveProjectRepository.getArchiveProjectsByUserAccountId(userAccount.getId(),paramGetLikeStr(searchVal)) ;
        if(list == null) {
            return  null ;
        }   else {
            List<ArchiveProjectBean> beanList = new ArrayList<ArchiveProjectBean>() ;
            for(ArchiveProject vo : list) {
                beanList.add(ArchiveProjectBeanFormat.entityToBean(vo)) ;
            }
            return beanList ;
        }
    }


    /**
     * 根据id查询 [归档项目]
     *
     * @param request
     * @param userAccount
     * @param projectId
     * @return
     * @throws Exception
     */
    @Override
    public ArchiveProjectBean doGetArchiveProjectById(HttpServletRequest request, UserAccount userAccount, String projectId) throws Exception {
        ArchiveProject vo =  archiveProjectRepository.findById(projectId).get();
        if(vo == null) {
            return null ;
        }   else {
            return  ArchiveProjectBeanFormat.entityToBean(vo);
        }
    }


    /**
     * 删除 [归档项目]
     *
     * @param request
     * @param archiveProjectId
     */
    @Override
    public void doDeleteArchiveProject(HttpServletRequest request, String archiveProjectId) {
        ArchiveProject entity = archiveProjectRepository.findById(archiveProjectId).get();
        entity.setState(ProjectStateEnum.DELETE.getValue());
        archiveProjectRepository.save(entity);
    }
>>>>>>> temp
}
