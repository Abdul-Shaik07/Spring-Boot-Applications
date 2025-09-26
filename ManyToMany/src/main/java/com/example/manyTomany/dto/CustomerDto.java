package com.example.manyTomany.dto;

import java.util.Set;

import com.example.manyTomany.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
	
	private String customerName;
	private String mobileNumber;
	private String email;
	private Set<Product> products;
}
