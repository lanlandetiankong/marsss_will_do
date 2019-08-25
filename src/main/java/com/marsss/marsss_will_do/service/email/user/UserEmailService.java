package com.marsss.marsss_will_do.service.email.user;

import com.marsss.marsss_will_do.bean.MyEmailSendBean;
import com.marsss.marsss_will_do.common.base.service.MyBaseEmailService;
import org.springframework.stereotype.Service;

@Service
public interface UserEmailService extends MyBaseEmailService{
    void sendSimpleEmail(String to, MyEmailSendBean emailSendBean) ;
    void sendSimpleEmail(String from,String to,MyEmailSendBean emailSendBean) ;
}
