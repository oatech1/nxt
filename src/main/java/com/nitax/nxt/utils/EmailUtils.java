package com.nitax.nxt.utils;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.nitax.nxt.dto.UserMsgDto;
@Component
public class EmailUtils {
	private JavaMailSender javaMailSender;
	
	public EmailUtils(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	//public boolean sendMail(UserMsgDto umd) {
	public boolean sendMail(UserMsgDto umd) {
		//boolean isSent =false;
		try {
			MimeMessage mimeMsg=javaMailSender.createMimeMessage();
			MimeMessageHelper helper =new MimeMessageHelper(mimeMsg, true);
			
			helper.setFrom("info@nxt.ng");
			helper.setTo(umd.getEmail());
			helper.setBcc("ayodele@nxt.ng");
			helper.setSubject("Re: "+umd.getMsg());
			helper.setText(getEmailBody(umd));
			javaMailSender.send(mimeMsg);
			//isSent= true;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return isSent;
		return false;
	}
	private String getEmailBody(UserMsgDto umd) throws IOException {
		 StringBuffer sb=new StringBuffer();
		 FileReader fr  =new FileReader("EMAIL-BODY-TMP.txt");
		 BufferedReader br=new BufferedReader(fr);
		 String ln =br.readLine();
		 while(ln !=null) {
			 sb.append(ln);
			 ln=br.readLine();
		 }
		 br.close();
		 String mailBody= sb.toString();
		 mailBody= mailBody.replace("{FNAME}", umd.getName());
		 mailBody= mailBody.replace("{EMAIL}", umd.getEmail());
		return mailBody;
	}
	public boolean sendMailNew(String to, String sub, String body) {
		//boolean isSent =false;
		try {
			SimpleMailMessage msg =new SimpleMailMessage();
		/*	helper.setTo(umd.getEmail());
			helper.setSubject("Re: "+umd.getMsg());
			helper.setText("Welcome to NXT", true);
			//helper.setText(getEmailBody(umd));*/
			msg.setTo((to));
			msg.setSubject(sub);
			msg.setText(body);
			javaMailSender.send(msg);
			//isSent= true;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return isSent;
		return false;
	}

}
