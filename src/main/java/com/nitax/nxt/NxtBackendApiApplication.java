package com.nitax.nxt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NxtBackendApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(NxtBackendApiApplication.class, args);
		SpringApplication.run(NxtBackendApiApplication.class, args);
			/*EmailUtils eu	=ctx.getBean(EmailUtils.class);
			String to ="oayodele111@gmail.com";
			String subj="Testing";
			String body= "Sent from Spring App";*/
			
			//boolean isSent=eu.sendMail(to, subj, body);
			
			//System.out.println("Is sent: "+  isSent);
	
	}

}
