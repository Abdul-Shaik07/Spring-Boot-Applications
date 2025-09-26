package com.java.mappings.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.mappings.Entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	
	List<Product> findProductsByCustomerId(long id);

}
