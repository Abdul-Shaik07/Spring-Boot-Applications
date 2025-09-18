package com.java.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(CustomerIdExistsException.class)
    public ResponseEntity<ErrorResponseMessage> getErrorResponse(CustomerIdExistsException customerIdExistsException) {
        ErrorResponseMessage errorResponseMessage =  new ErrorResponseMessage(customerIdExistsException.getMessage(), "FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.FOUND);
    }

    @ExceptionHandler({CustomerIdNotExistsException.class})
    public ResponseEntity<ErrorResponseMessage> getErrorResponse(CustomerIdNotExistsException customerIdNotExistsException) {
        ErrorResponseMessage errorResponseMessage =  new ErrorResponseMessage(customerIdNotExistsException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CustomersNotFoundException.class})
    public ResponseEntity<ErrorResponseMessage> getErrorResponse(CustomersNotFoundException customersNotFoundException) {
        ErrorResponseMessage errorResponseMessage =  new ErrorResponseMessage(customersNotFoundException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }
}
