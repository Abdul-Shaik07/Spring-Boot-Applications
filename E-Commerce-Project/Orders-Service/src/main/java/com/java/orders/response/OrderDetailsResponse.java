package com.java.orders.response;

import lombok.Data;

@Data
public class OrderDetailsResponse {
    private Long productId;
    private double price;
    private long quantity;
}
