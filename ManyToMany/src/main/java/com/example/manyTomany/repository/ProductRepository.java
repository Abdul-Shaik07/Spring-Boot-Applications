package com.example.manyTomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manyTomany.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
