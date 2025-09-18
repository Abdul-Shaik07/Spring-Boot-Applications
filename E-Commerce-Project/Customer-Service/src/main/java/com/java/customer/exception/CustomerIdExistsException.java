package com.java.customer.exception;

public class CustomerIdExistsException extends RuntimeException {
    public CustomerIdExistsException(String message) {
        super(message);
    }
}
