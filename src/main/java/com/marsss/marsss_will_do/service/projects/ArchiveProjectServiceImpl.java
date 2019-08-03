package com.marsss.marsss_will_do.service.projects;

import com.marsss.marsss_will_do.repository.projects.ActivityProjectRepository;
import com.marsss.marsss_will_do.repository.projects.ArchiveProjectRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.short_notes.ShortNoteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchiveProjectServiceImpl implements ArchiveProjectService {
    private Logger logger = LoggerFactory.getLogger(ArchiveProjectServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private ActivityProjectRepository activityProjectRepository ;
    @Autowired
    private ArchiveProjectRepository archiveProjectRepository ;





}
