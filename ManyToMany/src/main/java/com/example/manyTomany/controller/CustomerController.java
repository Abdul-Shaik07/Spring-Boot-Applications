package com.example.manyTomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manyTomany.dto.CustomerDto;
import com.example.manyTomany.entity.Customer;
import com.example.manyTomany.service.ICustomerService;

@RestController
@RequestMapping("/customer/api/")
public class CustomerController {
	@Autowired
	ICustomerService iCustomerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<Customer>(iCustomerService.saveCustomer(customerDto), HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") long customerId) {
		return new ResponseEntity<Customer>(iCustomerService.updateCustomer(customerDto, customerId), HttpStatus.OK);
	}

}
