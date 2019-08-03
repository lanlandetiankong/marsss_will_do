package com.marsss.marsss_will_do.repository.tasks;

import com.marsss.marsss_will_do.entity.tasks.Task;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TaskRepository extends JpaRepository<Task,String>{

}
