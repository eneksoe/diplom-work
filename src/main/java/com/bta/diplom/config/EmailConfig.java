package com.bta.diplom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/*@Configuration*/
public class EmailConfig {
    private static final String EMAIL_PASSWORD_ENV = "EMAIL_PASSWORD";

  /*  @Bean*/
    public JavaMailSender javaMailSender() {
        final String mailPassword = System.getenv(EMAIL_PASSWORD_ENV);

        var mailSender = new JavaMailSenderImpl();
        System.out.println("Email password:" + mailPassword);
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("betta12@gmail.com");
        mailSender.setPassword(mailPassword);
        final var properties = mailSender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp,auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}
