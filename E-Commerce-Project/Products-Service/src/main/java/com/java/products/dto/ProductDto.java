package com.java.products.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

	private long productId;
	@NotBlank(message = "Product Name should not be blank")
	private String productName;
	@NotNull(message = "Product Price should not be blank")
	private double productPrice;
	@NotNull(message = "Product Quantity should not be null")
	@Min(0)
	@Max(100)
	private int productQuantity;
	

}
