package com.marsss.marsss_will_do.service.tags;

import com.marsss.marsss_will_do.repository.tags.MyTagRepository;
import com.marsss.marsss_will_do.repository.tags.TaskTagRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTagServiceImpl implements TaskTagService {
    private Logger logger = LoggerFactory.getLogger(TaskTagServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository ;

    @Autowired
    private MyTagRepository tagRepository ;
    @Autowired
    private TaskTagRepository taskTagRepository ;


}
