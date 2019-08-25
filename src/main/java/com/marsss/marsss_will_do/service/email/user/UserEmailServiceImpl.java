package com.marsss.marsss_will_do.service.email.user;

import com.marsss.marsss_will_do.bean.MyEmailSendBean;
import com.marsss.marsss_will_do.common.base.service.MyBaseEmailServiceImpl;
import com.marsss.marsss_will_do.common.enums.email.MyUserEmailEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("userMailService")
public class UserEmailServiceImpl extends MyBaseEmailServiceImpl implements UserEmailService{
    @Value("${spring.mail.username}")
    private String fromUser ;
    @Autowired
    private JavaMailSender mailSender ;

    private MyUserEmailEnum defaultUserEmailEnum = MyUserEmailEnum.Default;



    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendSimpleEmail(String to, MyEmailSendBean emailSendBean) {
        sendSimpleEmail(fromUser,to,emailSendBean);
    }
    @Override
    public void sendSimpleEmail(String from,String to,MyEmailSendBean emailSendBean) {
        super.sendSimpleEmail(from,to,defaultUserEmailEnum.getTitle(),handleContentParamDeal(emailSendBean));
    }

    public String handleContentParamDeal(MyEmailSendBean emailSendBean) {
        String code = emailSendBean.getCode();
        if(StringUtils.isBlank(code)){
            return "" ;
        }   else {
            String content = defaultUserEmailEnum.getContent();
            content = String.format(content,code );
            return content ;
        }
    }
}
