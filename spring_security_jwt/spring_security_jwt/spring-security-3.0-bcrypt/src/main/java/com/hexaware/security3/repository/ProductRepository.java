package com.hexaware.security3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.security3.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}
