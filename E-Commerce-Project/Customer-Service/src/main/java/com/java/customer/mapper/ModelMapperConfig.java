package com.java.customer.mapper;

import com.java.customer.dto.CustomerDto;
import com.java.customer.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(CustomerDto.class, Customer.class)
                .addMappings(mapper -> mapper.skip(Customer::setCustomerId));

        return modelMapper;
    }
}
