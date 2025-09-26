package com.java.mappings.modelmapperconfig;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.mappings.Dto.CustomerDto;
import com.java.mappings.Entity.Customer;
@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper getModelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		//modelMapper.typeMap(CustomerDto.class, Customer.class).addMappings(mapper -> mapper.skip(Customer::setId));

		
		return modelMapper; 
	}

}
