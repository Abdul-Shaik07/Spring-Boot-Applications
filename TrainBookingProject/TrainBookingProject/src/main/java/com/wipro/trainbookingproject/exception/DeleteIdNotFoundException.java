package com.wipro.trainbookingproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DeleteIdNotFoundException extends Exception {
	@ResponseStatus(reason = "id is not found to delete", code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public void deleteNotFound() {
		
		System.out.println("Id is not found to delete");
		
	}

}
