package com.nitax.nxt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "USER_DTLS")
public class UserMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(
			name="useridseq",
			sequenceName="user_id_seq",
			allocationSize=1)
	@GeneratedValue(generator ="useridseq",
			strategy = GenerationType.SEQUENCE
			)

	@Column(name = "USER_ID")
	private Integer id;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name ="USER_PHONE_NO")
	private String phoneNo;
	
	@Column(name = "MESSAGE")
	private String msg;
	


}
