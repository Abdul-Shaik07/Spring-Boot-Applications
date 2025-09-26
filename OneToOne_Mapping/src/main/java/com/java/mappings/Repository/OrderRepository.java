package com.java.mappings.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.mappings.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
	
	List<Orders> findByName(String name);

}
