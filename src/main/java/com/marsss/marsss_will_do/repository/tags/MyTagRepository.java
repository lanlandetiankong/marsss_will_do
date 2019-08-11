package com.marsss.marsss_will_do.repository.tags;

import com.marsss.marsss_will_do.entity.tags.MyTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MyTagRepository extends JpaRepository<MyTags,String>{

    @Query("select t from MyTags t where t.userAccount.id= :accountId and t.state = 1 and t.name like :searchVal order by t.createDate desc")
    List<MyTags> getMyTagsByUserAccountId(@Param("accountId")String accountId,@Param("searchVal")String searchVal);
}
