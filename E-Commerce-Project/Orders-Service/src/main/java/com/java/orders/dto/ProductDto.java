package com.java.orders.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
	
	private Long productId;
	private String productName;
	private double productPrice;
	private int productQuantity;

}
