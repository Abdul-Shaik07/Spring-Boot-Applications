package com.wipro.spring.service;



import com.wipro.spring.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {

    Mono<Product> getProductbyId(Long id);
    Flux<Product> getAllProducts();
    Mono<Void> deletebyId(Long id);
	Mono<Product> insertProduct(Product product);
	
	Flux<Product> getUsersByName(String name);
	Mono<Object> updateProduct(long id, Product product);
}
