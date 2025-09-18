package com.java.orders.exception;

public class OrdersNotFoundException extends RuntimeException {
    public OrdersNotFoundException(String message) {
        super(message);
    }
}
