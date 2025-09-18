package com.java.products.exception;

public class ProductsNotFoundException extends RuntimeException {

    public ProductsNotFoundException(String message) {
        super(message);
    }
}
