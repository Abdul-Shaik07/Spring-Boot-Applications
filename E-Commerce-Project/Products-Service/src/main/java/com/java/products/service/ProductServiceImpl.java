package com.java.products.service;

import java.util.List;
import java.util.stream.Collectors;
import com.java.products.exception.ProductsNotFoundException;
import com.java.products.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.java.products.dto.ProductDto;
import com.java.products.entity.Product;
import com.java.products.exception.ProductIdNotFoundException;
import com.java.products.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

	@Override
	public ProductResponse saveProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = productRepository.save(product);
        return mapToResponse(savedProduct);

//        Product product = new Product();
//		product.setProductName(productDto.getProductName());
//		product.setProductPrice(productDto.getProductPrice());
//		product.setProductQuantity(productDto.getProductQuantity());
//		return
	}

    @Override
	public ProductResponse updateProduct(ProductDto productDto, long productId) {
		Product returningProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductIdNotFoundException("Product id is not found update"));
        modelMapper.map(productDto, returningProduct);
        Product updatedProduct = productRepository.save(returningProduct);
        return mapToResponse(updatedProduct);
//        if(byId.isPresent()) {
//			Product product = byId.get();
//			product.setProductName(productDto.getProductName());
//			product.setProductPrice(productDto.getProductPrice());
//			product.setProductQuantity(productDto.getProductQuantity());
//			return productRepository.save(product);
//		} else {
//			throw new ProductIdNotFoundException("Product is not match exact to update");
//		}
	}
	

	@Override
	public ProductResponse findByProductId(long productId) {

		Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductIdNotFoundException("product id is not found to fetch"));
        return mapToResponse(product);

//        if(product.getProductId() != productId) {
//			throw new ProductIdNotFoundException("Id is not found to fetch");
//		}
//
//		 ProductDto productDto = new ProductDto();
//		 productDto.setProductId(product.getProductId());
//		 productDto.setProductName(product.getProductName());
//		 productDto.setProductPrice(product.getProductPrice());
//		 productDto.setProductQuantity(product.getProductQuantity());
//		 return productDto;
		 
	}
	

	@Override
	public List<ProductResponse> getAllProducts() {
		// TODO Auto-generated method stub
		 List<Product> allProducts = productRepository.findAll();
		 if(allProducts.isEmpty()) {
			 throw new ProductsNotFoundException("No products left in the database");
		 }
         return allProducts.stream()
                 .map(this::mapToResponse)
                 .collect(Collectors.toList());
	}

	
	@Override
	public String deleteProductById(long productId) {
		boolean existsById = productRepository.existsById(productId);
		if(!existsById) {
            throw new ProductIdNotFoundException("Product id is not found to delete");
		}
        productRepository.deleteById(productId);
        return "Product id found and it's deleted with : " +productId;
	}
	

	@Override
	public String deleteAllProducts() {
		// TODO Auto-generated method stub
		List<Product> allProducts = productRepository.findAll();
		if(allProducts.isEmpty()) {
			throw new ProductsNotFoundException("No products in the database to delete");
		}
        productRepository.deleteAll();
        return "All the records deleted";
	}

    private ProductResponse mapToResponse(Product product) {
        return modelMapper.map(product, ProductResponse.class);
    }
}





