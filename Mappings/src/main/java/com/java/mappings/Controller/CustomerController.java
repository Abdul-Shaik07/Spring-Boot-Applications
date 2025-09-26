package com.java.mappings.Controller;

import java.util.List;
import java.util.Optional;import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mappings.Dto.CustomerDto;
import com.java.mappings.Entity.Customer;
import com.java.mappings.Entity.Product;
import com.java.mappings.Service.ICustomerService;
@RestController
@RequestMapping("/customer/api")
public class CustomerController {
	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<Customer>(iCustomerService.saveCustomer(customerDto), HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer>  updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable long id) {
		return new ResponseEntity<Customer>(iCustomerService.updateCustomer(customerDto, id), HttpStatus.OK);
	}
	
	@GetMapping("/findAllCustomers")
	public ResponseEntity<List<Customer>> findAllCustomers() {
		return new ResponseEntity<List<Customer>>(iCustomerService.findAllCustomers(), HttpStatus.OK) ;
	}
	
	@GetMapping("/findCustomerById/{id}")
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable long id) {
		return new ResponseEntity<Optional<Customer>>(iCustomerService.findCustomerById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomerById/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable long id) {
		return new ResponseEntity<String>(iCustomerService.deleteCustomerById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllCustomers")
	public ResponseEntity<String> deleteAllCustomers() {
		return new ResponseEntity<String>(iCustomerService.deleteAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/findCustomerNameByProductsName/{productName}")
	public ResponseEntity<List<String>> findCustomerNameByProductsName(@PathVariable String productName) {
		return new ResponseEntity<List<String>>(iCustomerService.findCustomerNameByProductsName(productName), HttpStatus.OK);
	}
	
	@GetMapping("/findProductsByCustomerId/{id}")
	public ResponseEntity<List<Product>> findProductsByCustomerId(@PathVariable long id) {
		return new ResponseEntity<List<Product>>(iCustomerService.findProductsByCustomerId(id), HttpStatus.OK);
	}
	
	@PatchMapping("/updateCustomerPartially/{id}")
	public ResponseEntity<Customer> updateCustomerPartially(@RequestBody CustomerDto customerDto, @PathVariable long id) {
		return new ResponseEntity<Customer>(iCustomerService.updateCustomerPartially(customerDto, id), HttpStatus.OK);
	}
}
