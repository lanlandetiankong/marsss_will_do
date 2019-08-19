package com.marsss.marsss_will_do.repository.tasks;

import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.tasks.Task;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TaskRepository extends JpaRepository<Task,String>{

    @Query("select t from Task t where t.userAccount.id = :account and t.state = 1 and t.name like :searchVal order by t.createDate desc")
    List<Task> getTasksByUserAccountId(@Param("account")String account, @Param("searchVal") String searchVal) ;
}
