package com.java.customer.controller;

import java.util.List;
import java.util.Optional;

import com.java.customer.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.customer.dto.CustomerDto;
import com.java.customer.entity.Customer;
import com.java.customer.service.ICustomerService;

@RestController
@RequestMapping("/customers/api")
@RequiredArgsConstructor
public class CustomerController {

	private final ICustomerService iCustomerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
		return ResponseEntity.ok(iCustomerService.saveCustomer(customerDto));
	}

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable long customerId ) {
        CustomerResponse customerResponse = iCustomerService.updateCustomer(customerDto, customerId);
        return ResponseEntity.ok(customerResponse);
    }

	@GetMapping("/findByCustomerId/{customerId}")
	public ResponseEntity<CustomerResponse> findByCustomerId(@PathVariable("customerId") long customerId) {
		return ResponseEntity.ok(iCustomerService.findByCustomerId(customerId));
	}

    @GetMapping("/findAllCustomers")
    public ResponseEntity<List<CustomerResponse>> findAllCustomers() {
        return ResponseEntity.ok(iCustomerService.getAllCustomers());
    }

    @DeleteMapping("/deleteCustomerById/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") long customerId) {
        return ResponseEntity.ok(iCustomerService.deleteCustomerById(customerId));
    }

    @DeleteMapping("/deleteAllCustomers")
    public ResponseEntity<String>  deleteAllCustomers() {
        return ResponseEntity.ok(iCustomerService.deleteAllCustomers());
    }
}
