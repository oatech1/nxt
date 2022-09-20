package com.nitax.nxt.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@AllArgsConstructor
public class MessageResponse {
	private HttpStatus status;
	private String message;
	private String module;
	private String date;

}
