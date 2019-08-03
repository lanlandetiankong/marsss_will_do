package com.marsss.marsss_will_do.service.projects;

import com.marsss.marsss_will_do.entity.projects.ActivityProject;

public interface ActivityProjectService {

    void doGetActivityProjectByUserId(String userId) ;

    void doCreateActivityProject(ActivityProject activityProject) ;

    void doUpdateActivityProject(ActivityProject activityProject) ;

    void doDeleteActivityProject(String activityProjectId);

    void doBatchDeleteActivityProject(String activityProjectIds);
}
