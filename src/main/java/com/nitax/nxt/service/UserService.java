package com.nitax.nxt.service;

import java.util.List;

import com.nitax.nxt.dto.UserMsgDto;

public interface UserService {
	
	boolean saveMsg(UserMsgDto u);
	
	List<UserMsgDto> getAllMessages();
}
