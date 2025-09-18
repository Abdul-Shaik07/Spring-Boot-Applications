package com.java.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//	@Query("drop table Product")
//	Product dropTable();
	

}
