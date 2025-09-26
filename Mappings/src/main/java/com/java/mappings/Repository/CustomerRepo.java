package com.java.mappings.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.mappings.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c.customerName FROM Customer c JOIN c.products p WHERE p.productName = :productName")
	//@Query(value = "select c.customer_name from customer c inner join product p on c.id = p.product_id where p.product_name = :productName", nativeQuery = true)
	List<String> findCustomerNameByProductsName(@Param("productName") String productName);

}
