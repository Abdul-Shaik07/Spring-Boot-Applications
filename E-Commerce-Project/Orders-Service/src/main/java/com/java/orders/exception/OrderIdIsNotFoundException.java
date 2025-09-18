package com.java.orders.exception;

public class OrderIdIsNotFoundException extends RuntimeException {
    public OrderIdIsNotFoundException(String message) {
        super(message);
    }

}
