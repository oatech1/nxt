package com.nitax.nxt.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitax.nxt.dto.UserMsgDto;
import com.nitax.nxt.response.MessageResponse;
import com.nitax.nxt.service.UserService;


@RestController
public class UserMgsEtyController {
	@Autowired
	private UserService service;
	
	@GetMapping({"/","/datainput"})
	public ResponseEntity<String> loadPage(){
		 UserMsgDto umd=new UserMsgDto();
		return null;
		
	}
	  @PostMapping(value = "/sendmsg",
			  		consumes = "application/json"
			  )
	public MessageResponse  handleSubmitBtn(@RequestBody UserMsgDto u){
		MessageResponse response =null;
		try {
			boolean isSaved=service.saveMsg(u);
			String body= "Message Sent Successfully: ";
			response =MessageResponse
					.builder()
					.status(HttpStatus.OK)
					.message(body)
					.module("Message")
					.date(new Date().toString())
					.build();
		}catch(Exception e) { 
			throw e;
		}
		
		
		return response;
		
	}

}
