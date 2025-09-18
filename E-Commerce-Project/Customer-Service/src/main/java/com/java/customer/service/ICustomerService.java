package com.java.customer.service;

import java.util.List;
import java.util.Optional;

import com.java.customer.dto.CustomerDto;
import com.java.customer.entity.Customer;
import com.java.customer.response.CustomerResponse;


public interface ICustomerService {

	CustomerResponse saveCustomer(CustomerDto customerDto);
	
	CustomerResponse
    updateCustomer(CustomerDto customerDto, long customerId);
	
	CustomerResponse findByCustomerId(long customerId);
	
	List<CustomerResponse> getAllCustomers();
	
	String deleteCustomerById(long customerId);
	
	String deleteAllCustomers();
	
}
