package com.wipro.trainbookingproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TrainIdNotFoundException.class)
	public ResponseEntity<ErrorResponseMessage> findTrainById(TrainIdNotFoundException t) {
		
		ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(t.getMessage(), "NOT_FOUND");
		
		return new ResponseEntity<ErrorResponseMessage>(errorResponseMessage, HttpStatus.NOT_FOUND);
	
		
	}
	
	
}
