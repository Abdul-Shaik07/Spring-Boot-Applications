package com.java.products.exception;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorResponseMessage {
	
	private String message;
	private String error;
	private LocalDateTime localDateTime;
	
	public ErrorResponseMessage(String message, String error) {
		this.message = message;
		this.error = error;
		this.localDateTime = LocalDateTime.now();
	}

	
	
	

}
