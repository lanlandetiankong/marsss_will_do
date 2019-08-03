package com.marsss.marsss_will_do.service.tasks;

import com.marsss.marsss_will_do.repository.tasks.SubTaskRepository;
import com.marsss.marsss_will_do.repository.tasks.TaskRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.user.UserAccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTaskServiceImpl implements SubTaskService {
    private Logger logger = LoggerFactory.getLogger(SubTaskServiceImpl.class);

    @Autowired
    private TaskRepository taskRepository ;
    @Autowired
    private SubTaskRepository subTaskRepository ;
    @Autowired
    private UserAccountRepository userAccountRepository ;

}
