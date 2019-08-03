package com.marsss.marsss_will_do.repository.short_notes;

import com.marsss.marsss_will_do.entity.short_notes.ShortNote;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ShortNoteRepository extends JpaRepository<ShortNote,String>{

}
