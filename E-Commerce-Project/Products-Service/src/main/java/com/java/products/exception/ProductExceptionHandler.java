package com.java.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ErrorResponseMessage> getProductIdNotFoundException(ProductIdNotFoundException e) {
		ErrorResponseMessage errorResponse = new ErrorResponseMessage(e.getMessage(), "NOT_FOUND");
		return new ResponseEntity<ErrorResponseMessage>(errorResponse, HttpStatus.NOT_FOUND);
	}

    @ExceptionHandler(ProductsNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> getProductsNotFoundException(ProductsNotFoundException e) {
        ErrorResponseMessage errorResponse = new ErrorResponseMessage(e.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
