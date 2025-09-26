package com.example.manyTomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manyTomany.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
