package com.java.customer.exception;

public class CustomersNotFoundException extends RuntimeException {
    public CustomersNotFoundException(String message) {
        super(message);
    }
}
