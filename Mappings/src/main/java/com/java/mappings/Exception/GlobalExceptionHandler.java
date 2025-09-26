package com.java.mappings.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<ErrorResponseMessage> getErrorResponse(CustomerIdNotFoundException c) {
		ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(c.getMessage(), "NOT_FOUND");
		return new ResponseEntity<ErrorResponseMessage>(errorResponseMessage, HttpStatus.NOT_FOUND);
	}

}
