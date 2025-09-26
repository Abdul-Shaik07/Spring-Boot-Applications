package com.example.manyTomany.service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.manyTomany.dto.CustomerDto;
import com.example.manyTomany.dto.ProductDto;
import com.example.manyTomany.entity.Customer;
import com.example.manyTomany.entity.Product;
import com.example.manyTomany.repository.CustomerRepository;
import com.example.manyTomany.repository.ProductRepository;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private final CustomerRepository customerRepository = null;
	@Autowired
	private final ProductRepository productRepository = null;
	
	Customer customer;

	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
		customer = new Customer();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		

		if(customerDto.getProducts() != null) {
			Set<Product> addProducts = new HashSet<>();
			for(Product productDto : customerDto.getProducts()) {
				Product product = new Product();
				product.setProductName(productDto.getProductName());
				product.setPrice(productDto.getPrice());
				product.setQuantity(productDto.getQuantity());
				product.setAvailability(productDto.isAvailability());
				addProducts.add(product);
				
//				Set<Customer> addCustomers = new HashSet<>();
//				addCustomers.add(customer);
//				product.setCustomers(addCustomers);
				
				
			}
			customer.setProducts(addProducts);
		}
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(CustomerDto customerDto, long customerId) {
		Optional<Customer> byId = customerRepository.findById(customerId);
		if(byId.isEmpty()) {
			throw new RuntimeException("Customer id is not found");
		}
		Customer customer2 = byId.get();
		customer2.setCustomerName(customerDto.getCustomerName());
		customer2.setEmail(customerDto.getEmail());
		customer2.setMobileNumber(customerDto.getMobileNumber());
		if(customerDto.getProducts()!=null) {
			Set<Product> addproducts = new HashSet<>();
			for(Product productDto : customerDto.getProducts()) {
				Optional<Product> byId2 = productRepository.findById(productDto.getProductId());
				if(byId2.isEmpty()) {
					throw new RuntimeException("Product with ID " + productDto.getProductId() + " not found");
				}
				Product product = byId2.get();
				product.setProductName(productDto.getProductName());
				product.setPrice(productDto.getPrice());
				product.setQuantity(productDto.getQuantity());
				product.setAvailability(productDto.isAvailability());
				addproducts.add(product);			
				if(product.getCustomers() == null) {
					product.setCustomers(new HashSet<>());
				}
				product.getCustomers().add(customer2);
			}
			customer2.setProducts(addproducts);
		}	
		return customerRepository.save(customer2);
	}

	@Override
	public Optional<Customer> findCustomerById(long customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> byId = customerRepository.findById(customerId);
		if(byId.isEmpty()) {
			throw new RuntimeException("Customer id is not found to fetch");
		}
		return byId;
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> all = customerRepository.findAll();
		if(all.isEmpty()) {
			throw new RuntimeException("Customers is not found to fetch");
		}
		return all;
	}

	@Override
	public void deleteCustomerById(long customerById) {
		// TODO Auto-generated method stub
		Optional<Customer> byId = customerRepository.findById(customerById);
		if(byId.isEmpty()) {
			throw new RuntimeException("Customer id is not found to fetch");
		}
		customerRepository.deleteById(customerById);

	}

	@Override
	public void deleteAllCustomers() {
		// TODO Auto-generated method stub
		
		List<Customer> all = customerRepository.findAll();
		if(all.isEmpty()) {
			throw new RuntimeException("Customer id is not found to fetch");
		}
		customerRepository.deleteAll();

	}

}
