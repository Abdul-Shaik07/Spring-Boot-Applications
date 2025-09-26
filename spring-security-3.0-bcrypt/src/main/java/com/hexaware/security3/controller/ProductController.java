package com.hexaware.security3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.security3.dto.ProductDto;
import com.hexaware.security3.entity.Product;
import com.hexaware.security3.entity.UserInfo;
import com.hexaware.security3.service.IProductService;
import com.hexaware.security3.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/public/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

   
//    @GetMapping("/getall")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public List<ProductDto> getAllTheProducts() {
//        return iProductService.findAllProducts();
//    }
//
//    
//    public ProductDto getProductById(@PathVariable int id) {
//        return service.getProduct(id);
//    }
    
    
    
    
    @PostMapping("/admin/addProduct")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Product addProduct(@RequestBody ProductDto productDto) {
		return iProductService.addProduct(productDto);
	}
    
    @PutMapping("/admin/updateProduct")
    @PreAuthorize("hasAuthority('ADMIN')")
	public Product updateProduct(@RequestBody ProductDto productDto) {
		
		
		return iProductService.addProduct(productDto);
	}

	@GetMapping("/user/findAll")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	public List<Product> findAllProducts() {

		return iProductService.findAllProducts();
	}

	@GetMapping("/user/findProductId/{productId}")
    @PreAuthorize("hasAuthority('USER')")
	public Product findProductById(@PathVariable int productId) {
		
		return iProductService.findProductById(productId);
	}
    
    
}
