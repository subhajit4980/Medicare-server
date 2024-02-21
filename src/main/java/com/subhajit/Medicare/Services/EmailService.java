package com.subhajit.Medicare.Services;


import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService
{
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration config;
    @SneakyThrows
    public void sendEmail(String email, String subject, Template t , Map<String, Object> model) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setTo(email);
        helper.setText(html, true);
        helper.setSubject(subject);
        javaMailSender.send(mimeMessage);
    }
}