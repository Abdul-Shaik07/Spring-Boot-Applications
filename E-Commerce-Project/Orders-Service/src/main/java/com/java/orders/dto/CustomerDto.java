package com.java.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
	private Long customerId;
	private String customerName;
	private String email;
	private String mobileNumber;
	private String address;
	

}
