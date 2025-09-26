package com.java.mappings.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.mappings.Entity.Customer;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
	private long productId;
	private String productName;
	private double productPrice;
	private long quantity;
	private CustomerDto customer;

}
