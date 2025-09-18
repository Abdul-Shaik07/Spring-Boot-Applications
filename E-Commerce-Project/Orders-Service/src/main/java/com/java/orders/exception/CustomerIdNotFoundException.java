package com.java.orders.exception;

public class CustomerIdNotFoundException extends RuntimeException {
    public CustomerIdNotFoundException(String message) {
        super(message);
    }
}
