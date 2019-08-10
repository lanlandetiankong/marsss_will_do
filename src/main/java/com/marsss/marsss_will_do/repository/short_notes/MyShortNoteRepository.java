package com.marsss.marsss_will_do.repository.short_notes;

import com.marsss.marsss_will_do.entity.short_notes.MyShortNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MyShortNoteRepository extends JpaRepository<MyShortNotes,String>{

    @Query(value = "select c from MyShortNotes c where c.userAccount.id = :accountId and c.content like :searchVal and c.state = 1 order by c.createDate desc")
    List<MyShortNotes> getMyShortNotesByUserAccountId(@Param("accountId") String accountId,@Param("searchVal") String searchVal) ;
}
