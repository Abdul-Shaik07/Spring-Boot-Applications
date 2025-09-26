package com.example.manyTomany.dto;

import java.util.Set;
import com.example.manyTomany.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
	
	private long productId;
	private String productName;
	private double price;
	private long quantity;
	private boolean availability;
	private Set<Customer> customers;

}
