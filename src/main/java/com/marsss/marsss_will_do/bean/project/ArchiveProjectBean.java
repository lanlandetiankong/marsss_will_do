package com.marsss.marsss_will_do.repository.projects;

import com.marsss.marsss_will_do.entity.projects.ArchiveProject;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ArchiveProjectRepository extends JpaRepository<ArchiveProject,String>{

}
