package com.java.mappings.Service;

import java.util.List;
import java.util.Optional;

import com.java.mappings.Dto.CustomerDto;
import com.java.mappings.Entity.Customer;
import com.java.mappings.Entity.Product;

public interface ICustomerService {
	
	 Customer saveCustomer(CustomerDto customerDto);
	 Customer updateCustomer(CustomerDto customerDto, long id);
	 Customer updateCustomerPartially(CustomerDto customerDto, long id);
	 Optional<Customer> findCustomerById(long id);
	 List<Customer> findAllCustomers();
	 String deleteCustomerById(long id);
	 String deleteAllCustomers();
	 List<String> findCustomerNameByProductsName(String customerName);
	 List<Product> findProductsByCustomerId(long id);
	 
	

}
