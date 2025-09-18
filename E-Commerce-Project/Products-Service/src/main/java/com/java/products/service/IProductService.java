package com.java.products.service;

import java.util.List;
import com.java.products.dto.ProductDto;
import com.java.products.response.ProductResponse;

public interface IProductService {
	
	ProductResponse saveProduct(ProductDto productDto);
    ProductResponse updateProduct(ProductDto productDto, long productId);
    ProductResponse findByProductId(long productId);
	List<ProductResponse> getAllProducts();
	String deleteProductById(long productId);
	String deleteAllProducts();
	
	

}
