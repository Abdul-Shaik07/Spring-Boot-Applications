package com.wipro.spring.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

import com.wipro.spring.entity.Product;
import com.wipro.spring.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private DatabaseClient databaseClient;

    @Override
    public Mono<Product> insertProduct(Product product) {
        return  this.databaseClient.sql("INSERT INTO product_table (id,name, price) VALUES (:id,:name, :price)")
        		.filter((statement,executeFunction) -> statement.returnGeneratedValues("product").execute())
                .bind("id", product.getId())
                .bind("name", product.getName())
                .bind("price", product.getPrice())
                .fetch()
                .first()
                .map((r)->{return product;}); // Explicitly return as Object
    }

    @Override
    public Mono<Object> updateProduct(long id,Product product) {
        return this.databaseClient.sql("UPDATE my_table SET name = :name, price = :price WHERE id = :id")
        		.filter((statement,executeFunction) -> statement.returnGeneratedValues("product").execute())
                .bind("id", id)
                .bind("name", product.getName())
                .bind("price", product.getPrice())
                .fetch()
                  .first()
                .map((r)->{return product;});  
        
        
    }
    @Override
	public Flux<Product> getUsersByName(String name) {
	
		return repo.findByName(name);
	}


    @Override
    public Mono<Product> getProductbyId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Flux<Product> getAllProducts() {
        return repo.findAll().delayElements(Duration.ofSeconds(2));
    }

    @Override
    public Mono<Void> deletebyId(Long id) {
        return repo.deleteById(id);
    }


}
