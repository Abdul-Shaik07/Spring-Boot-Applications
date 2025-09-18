package com.java.products.response;

import lombok.Data;

@Data
public class ProductResponse {

    private long productId;
    private String productName;

    private double productPrice;

    private int productQuantity;
}
