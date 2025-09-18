package com.java.orders.client;


import com.java.orders.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {

	@GetMapping("/products/api/findByProductId/{productId}")
    ProductResponse findByProductId(@PathVariable("productId") long productId);
}
