package com.java.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderIdIsNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> orderIdIsNotFoundException(OrderIdIsNotFoundException orderIdIsNotFoundException){
        ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(orderIdIsNotFoundException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrdersNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> ordersNotFoundException(OrdersNotFoundException ordersNotFoundException){
        ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(ordersNotFoundException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> customerIdNotFoundException(CustomerIdNotFoundException customerIdNotFoundException){
        ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(customerIdNotFoundException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }
}


