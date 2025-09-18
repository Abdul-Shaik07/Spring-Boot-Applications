package com.java.orders.response;

import java.time.LocalDate;
import java.util.List;

import com.java.orders.dto.CustomerDto;
import com.java.orders.dto.Orderdto;
import com.java.orders.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsWithCustomerAndProducts {
	
	
	private long orderId;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private CustomerResponse customers;
	private List<ProductResponse> products;
	
	/*
	 * private Orderdto orderdto; private CustomerDto customerDto; private
	 * ProductDto productDto;
	 */
	
//	private long orderId;
//	private long customerId;
//	private String customerName;
//	private String email;
//	private String mobileNumber;
//	private String customerAddress;
//	private long productId;
//	private String productName;
//	private double productPrice;
//	private long productQuantity;
//	private LocalDate orderDate;
//	private LocalDate deliveryDate;

}
