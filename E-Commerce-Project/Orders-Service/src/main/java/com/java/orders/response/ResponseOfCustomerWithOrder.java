package com.java.orders.response;

import java.time.LocalDate;

import com.java.orders.dto.CustomerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOfCustomerWithOrder {
	
	private long orderId;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private CustomerResponse customers;

}
