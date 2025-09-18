package com.java.products.controller;

import java.util.List;
import java.util.Optional;

import com.java.products.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.products.dto.ProductDto;
import com.java.products.entity.Product;
import com.java.products.service.IProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products/api")
@RequiredArgsConstructor
public class ProductController {

	private final IProductService iProductService;

	@PostMapping("/saveProduct")
	public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductDto productDto) {
		return ResponseEntity.ok(iProductService.saveProduct(productDto));
	}
	
	@PutMapping("/updateProduct/{productId}")
	public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductDto productDto, @PathVariable("productId") long productId) {
        ProductResponse productResponse = iProductService.updateProduct(productDto, productId);
        return ResponseEntity.ok(productResponse);
	}
	
	
	@GetMapping("/findByProductId/{productId}")
	public ResponseEntity<ProductResponse> findByProductId(@PathVariable("productId") long productId) {
		return ResponseEntity.ok(iProductService.findByProductId(productId));
	}
	
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		return ResponseEntity.ok(iProductService.getAllProducts());
	}
	
	
	@DeleteMapping("/deleteProductById/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId") long productId) { 
		return ResponseEntity.ok(iProductService.deleteProductById(productId));
	}
	
	
	@DeleteMapping("/deleteAllProducts")
	public ResponseEntity<String> deleteAllProducts() {
		return ResponseEntity.ok(iProductService.deleteAllProducts());
	}
}
