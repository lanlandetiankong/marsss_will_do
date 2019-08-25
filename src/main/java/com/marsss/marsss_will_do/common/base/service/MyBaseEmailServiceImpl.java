package com.marsss.marsss_will_do.common.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.Date;
import java.util.List;

public class MyBaseEmailServiceImpl implements MyBaseEmailService {
    @Autowired
    private JavaMailSender mailSender;
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void sendSimpleEmail(String from, String to, String title, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage() ;
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(title);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
        logger.info("发送给 "+to+ " 的标题为< " + title + " >邮件已经发送");
    }

    public void sendAttachmentsMail(String from,String to,String title, String cotent, List<File> fileList) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(cotent);
            String fileName = null;
            for (File file : fileList) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                helper.addAttachment(fileName, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
        logger.info("发送给 "+to+ " 的标题为< " + title + " >邮件已经发送");
    }


}
