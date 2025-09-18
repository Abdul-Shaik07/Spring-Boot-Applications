package com.java.orders.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private long customerId;
    private String customerName;
    private String email;
    private String mobileNumber;
    private String address;
}
