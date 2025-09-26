package com.wipro.trainbookingproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class TrainIdNotFoundException extends RuntimeException {
	
	

	public TrainIdNotFoundException(String message) {
		super(message);
	}
	
	

}
