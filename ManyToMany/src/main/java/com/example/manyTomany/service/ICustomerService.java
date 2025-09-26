package com.example.manyTomany.service;

import java.util.List;
import java.util.Optional;

import com.example.manyTomany.dto.CustomerDto;
import com.example.manyTomany.entity.Customer;

public interface ICustomerService {
	
	Customer saveCustomer(CustomerDto customerDto);
	Customer updateCustomer(CustomerDto customerDto, long customerId);
	Optional<Customer> findCustomerById(long customerId);
	List<Customer> findAllCustomers();
	void deleteCustomerById(long customerById);
	void deleteAllCustomers();
	

}
