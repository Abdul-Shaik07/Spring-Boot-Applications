package com.wipro.spring.resController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.spring.entity.Product;
import com.wipro.spring.service.IProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping("/insert")
    public Mono<Product> insertProduct(@RequestBody Product product) {
    	System.out.println(product);
        return service.insertProduct(product);
    }

    @PutMapping("/update/{id}")
    public Mono<Object> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/getall")
    public Flux<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/getbyid/{id}")
    public Mono<Product> getProductbyId(@PathVariable Long id) {
        return service.getProductbyId(id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return service.deletebyId(id);
    }
}
