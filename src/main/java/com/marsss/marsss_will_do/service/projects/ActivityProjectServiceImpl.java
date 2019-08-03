package com.marsss.marsss_will_do.service.projects;

import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.repository.projects.ActivityProjectRepository;
import com.marsss.marsss_will_do.repository.projects.ArchiveProjectRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityProjectServiceImpl implements ActivityProjectService {
    private Logger logger = LoggerFactory.getLogger(ActivityProjectServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private ActivityProjectRepository activityProjectRepository ;
    @Autowired
    private ArchiveProjectRepository archiveProjectRepository ;


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
    }
}
