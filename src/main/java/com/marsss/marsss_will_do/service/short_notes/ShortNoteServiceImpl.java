package com.marsss.marsss_will_do.service.short_notes;

import com.marsss.marsss_will_do.repository.short_notes.ShortNoteRepository;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.tags.TagServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortNoteServiceImpl implements  ShortNoteService {
    private Logger logger = LoggerFactory.getLogger(ShortNoteServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository ;

    @Autowired
    private ShortNoteRepository shortNoteRepository ;
}
