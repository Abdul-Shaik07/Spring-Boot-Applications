package com.java.mappings.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mappings.Dto.CustomerDto;
import com.java.mappings.Dto.ProductDto;
import com.java.mappings.Entity.Customer;
import com.java.mappings.Entity.Product;
import com.java.mappings.Exception.CustomerIdNotFoundException;
import com.java.mappings.Repository.CustomerRepo;
import com.java.mappings.Repository.ProductRepo;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
		
		Customer customer = modelMapper.map(customerDto, Customer.class);
	
		
//		Customer customer = new Customer();
//		
//		customer.setCustomerName(customerDto.getCustomerName());
//		customer.setEmailId(customerDto.getEmailId());
//		customer.setMobileNumber(customerDto.getMobileNumber());
	
		if (customerDto.getProducts() != null) {
			List<Product> productList = new ArrayList<>();
			for(ProductDto productDto : customerDto.getProducts()) {
				Product product = modelMapper.map(productDto, Product.class);
				product.setCustomer(customer);
				
//            Product product = new Product();
//            product.setProductName(productDto.getProductName());
//            product.setProductPrice(productDto.getProductPrice());
//            product.setQuantity(productDto.getQuantity());
//            product.setCustomer(customer); // important for bidirectional mapping
            
				
			productList.add(product);
        }
        customer.setProducts(productList);
		}
		return customerRepo.save(customer);
    }
		
	@Override
	public Customer updateCustomer(CustomerDto customerDto, long id) {
		Optional<Customer> byId = customerRepo.findById(id);
		if(byId.isEmpty()) {
			throw new CustomerIdNotFoundException("Customer id is not fund to update");
		} 
		Customer customer = byId.get();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmailId(customerDto.getEmailId());
		customer.setMobileNumber(customerDto.getMobileNumber());
		//modelMapper.map(customerDto, customer);
	
		if(customerDto.getProducts() != null) {
			List<Product> addProducts = new ArrayList<>();
			for(ProductDto productDto : customerDto.getProducts()) {
				Optional<Product> byId2 = productRepo.findById(productDto.getProductId());
				if(byId2.isEmpty()) {
					throw new CustomerIdNotFoundException("Product id is not fund to update");
				} 
				
				Product product = byId2.get();
				product.setProductName(productDto.getProductName());
				product.setProductPrice(productDto.getProductPrice());
				product.setQuantity(productDto.getQuantity());
				//modelMapper.map(productDto, product);
				product.setCustomer(customer);
				addProducts.add(product);
				
			}
			customer.setProducts(addProducts);
		}
		return customerRepo.save(customer);
	}
	
	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> all = customerRepo.findAll();
		if(all.isEmpty()) {
			throw new CustomerIdNotFoundException("Customers are not fund to update");
		} else {
			return all;
		}
	}


	@Override
	public Optional<Customer> findCustomerById(long id) {
		
		Optional<Customer> byId = customerRepo.findById(id);
		
		if(byId.isPresent()) {
			return byId;
		} else {
			throw new CustomerIdNotFoundException("Customer id is not found to fetch");
		}
	}


	@Override
	public String deleteCustomerById(long id) {
		Optional<Customer> byId = customerRepo.findById(id);
		if(byId.isPresent()) {
			customerRepo.deleteById(id);
			return "Record deleted: " +id;
		} else {
			throw new CustomerIdNotFoundException("Customer id is not found to delete");
		}
	}


	@Override
	public String deleteAllCustomers() {
		List<Customer> all = customerRepo.findAll();
		if(all.isEmpty()) {
			throw new CustomerIdNotFoundException("Customers are not found to delete");
		} else {
			customerRepo.deleteAll();
			return "All records deleted in the Customers table";
		}
	}

	@Override
	public List<String> findCustomerNameByProductsName(String productName) {
		// TODO Auto-generated method stub
		List<String> productsByCustomerName = customerRepo.findCustomerNameByProductsName(productName);
		if(productsByCustomerName.isEmpty()) {
			throw new CustomerIdNotFoundException("Customer Name is not found to fetch");
		} else {
			return productsByCustomerName;
			
		}
	}

	@Override
	public List<Product> findProductsByCustomerId(long id) {
		// TODO Auto-generated method stub
		List<Product> productsByCustomerId = productRepo.findProductsByCustomerId(id);
		if(productsByCustomerId.isEmpty()) {
			throw new CustomerIdNotFoundException("Products not found to fetch");
		}
		return productsByCustomerId;
	}

	@Override
	public Customer updateCustomerPartially(CustomerDto customerDto, long id) {
		Optional<Customer> byId = customerRepo.findById(id);
		if(byId.isEmpty()) {
			throw new CustomerIdNotFoundException("Customer id is not found to update partially");
		}
		Customer customer = byId.get();
		if(customerDto.getCustomerName() != null) {
			customer.setCustomerName(customerDto.getCustomerName());
		}
		if(customerDto.getEmailId() != null) {
			customer.setEmailId(customerDto.getEmailId());
		}
		if(customerDto.getMobileNumber() != null) {
			customer.setMobileNumber(customerDto.getMobileNumber());
		}
		if(customerDto.getProducts() != null && !customerDto.getProducts().isEmpty()) {
		List<Product> addProduct = new ArrayList<>();
		for(ProductDto productDto : customerDto.getProducts()) {
			Optional<Product> byId2 = productRepo.findById(productDto.getProductId());
			if(byId2.isEmpty()) {
				throw new CustomerIdNotFoundException("Product id is not found to update partially");
			}
			Product product = byId2.get();
			if (productDto.getProductName() != null) {
                product.setProductName(productDto.getProductName());
			}

            if (productDto.getProductPrice() != 0.0) {
                product.setProductPrice(productDto.getProductPrice());
            }

            if (productDto.getQuantity() != 0) {
                product.setQuantity(productDto.getQuantity());
            }
			
			product.setCustomer(customer);
			addProduct.add(product);
		}
		customer.setProducts(addProduct);
		
		}
		return customerRepo.save(customer);
	}
}
