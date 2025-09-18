package com.java.customer.exception;

public class CustomerIdNotExistsException extends RuntimeException{

    public CustomerIdNotExistsException(String message) {
        super(message);
    }
}
