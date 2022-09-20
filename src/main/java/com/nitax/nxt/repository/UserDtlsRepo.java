package com.nitax.nxt.repository;



import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitax.nxt.entities.UserMsgEntity;



public interface UserDtlsRepo extends JpaRepository<UserMsgEntity, Serializable> {

}
