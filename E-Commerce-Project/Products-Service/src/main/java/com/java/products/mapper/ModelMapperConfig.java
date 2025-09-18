package com.java.products.mapper;

import com.java.products.dto.ProductDto;
import com.java.products.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(ProductDto.class, Product.class)
                .addMappings(mapper -> mapper.skip(Product::setProductId));
        return modelMapper;
    }
}
