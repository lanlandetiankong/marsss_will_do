package com.marsss.marsss_will_do.repository.tags;

import com.marsss.marsss_will_do.entity.tags.TaskTag;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TaskTagRepository extends JpaRepository<TaskTag,String>{

}
