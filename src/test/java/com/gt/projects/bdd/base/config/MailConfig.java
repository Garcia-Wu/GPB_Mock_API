package com.gt.projects.bdd.base.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class MailConfig {
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    @Value("${mail.host}")
    private String mailHost;
    
    @Value("${mail.port}")
    private Integer mailPort;
    
    @Value("${mail.starttls}")
    private Boolean mailStarttls;
    
    @Value("${mail.transport.protocol}")
    private String mailTransportProtocol;
    
    @Bean
    protected JavaMailSender configureMailSender() throws IOException{
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);
    
//        mailSender.setUsername("my.gmail@gmail.com");
//        mailSender.setPassword("password");
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailTransportProtocol);
        props.put("mail.smtp.starttls.enable", mailStarttls);
//        props.put("mail.debug", "true");
//        props.put("mail.smtp.auth", "true");
        
        return mailSender;
    }
    
    
}
