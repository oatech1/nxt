package com.nitax.nxt.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitax.nxt.dto.UserMsgDto;
import com.nitax.nxt.entities.UserMsgEntity;
import com.nitax.nxt.repository.UserDtlsRepo;
import com.nitax.nxt.service.UserService;
import com.nitax.nxt.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {
		
		private UserDtlsRepo userRepo;      
	public UserServiceImpl(UserDtlsRepo userRepo) {
			this.userRepo = userRepo;
		}
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean saveMsg(UserMsgDto u) {
		UserMsgEntity uentity= new UserMsgEntity();
		BeanUtils.copyProperties(u, uentity);
		UserMsgEntity savedMsgEty=userRepo.save(uentity);
		if(savedMsgEty.getId()!=null) {
			return emailUtils.sendMail(u);
		}
		return false;
	}

	@Override
	public List<UserMsgDto> getAllMessages() {
		
		return null;
	}
	
	

}
