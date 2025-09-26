package com.hexaware.security3.service;

import java.util.List;

import com.hexaware.security3.dto.ProductDto;
import com.hexaware.security3.entity.Product;

public interface IProductService {
	
	Product addProduct(ProductDto productDto);
	
	Product updateProduct(ProductDto productDto);
	
	List<Product> findAllProducts();
	
	Product findProductById(int productId);
	
	

}
