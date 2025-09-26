package com.java.mappings.Dto;

import java.util.List;

import com.java.mappings.Entity.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
	//private long id;
	private String customerName;
	private String emailId;
	private String mobileNumber;
	private List<ProductDto> products;

}
