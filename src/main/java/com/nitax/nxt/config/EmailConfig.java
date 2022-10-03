package com.nitax.nxt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
		
		JavaMailSenderImpl mail=new JavaMailSenderImpl();
		mail.setHost("smtp-mail.outlook.com");
		mail.setPort(465);
		mail.setUsername("admin@nxt.ng");
		mail.setPassword("#Nxt2022");
		
		Properties props=mail.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.debug", "true");
		
		return mail;
		
	}
}
