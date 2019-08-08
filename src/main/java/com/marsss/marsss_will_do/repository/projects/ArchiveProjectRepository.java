package com.marsss.marsss_will_do.repository.projects;

import com.marsss.marsss_will_do.common.base.dao.MySimpleRepository;
import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface ArchiveProjectRepository extends MySimpleRepository<ArchiveProject,String> {
    @Query(value = "select p from ArchiveProject p where p.userAccount.id = :account and p.state = 1 and p.name like :searchVal")
    List<ArchiveProject> getArchiveProjectsByUserAccountId(@Param("account") String accountId, @Param("searchVal") String searchVal) ;
}
