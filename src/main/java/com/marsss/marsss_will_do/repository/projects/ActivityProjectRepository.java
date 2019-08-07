package com.marsss.marsss_will_do.repository.projects;

import com.marsss.marsss_will_do.common.base.dao.MySimpleRepository;
import com.marsss.marsss_will_do.entity.projects.ActivityProject;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ActivityProjectRepository extends MySimpleRepository<ActivityProject,String> {

    @Query("select p from ActivityProject p where p.userAccount.id = :account and p.state = 1 and p.name like :searchVal and p.isTranslateArchive <> 1 order by p.createDate desc")
    List<ActivityProject> getActivityProjectsByUserAccountId(@Param("account")String account,@Param("searchVal") String searchVal) ;
}
