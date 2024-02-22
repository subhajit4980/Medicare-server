package com.subhajit.Medicare.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.Properties;

/**
 * Configuration class for email-related beans.
 */
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class EmailConfig {

    // Injecting email properties from application.properties
    @Value("${spring.mail.host}")
    private String mailHost;
    @Value("${spring.mail.port}")
    private String mailPort;
    //    username added from environment variable
    private final String mailUsername = System.getenv("email");
    //    password added from environment variable
    private final String mailPassword = System.getenv("APP_PASSWORD");

    // Bean for JavaMailSender
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(Integer.parseInt(mailPort));
        javaMailSender.setUsername(mailUsername);
        javaMailSender.setPassword(mailPassword);
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true");
        return javaMailSender;
    }

    // Primary bean for FreeMarker configuration
    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean factoryBean() {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        return bean;
    }
}
