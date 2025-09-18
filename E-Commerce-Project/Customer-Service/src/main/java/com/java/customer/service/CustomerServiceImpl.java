package com.java.customer.service; 
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.customer.exception.CustomerIdExistsException;
import com.java.customer.exception.CustomerIdNotExistsException;
import com.java.customer.exception.CustomersNotFoundException;
import com.java.customer.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.java.customer.dto.CustomerDto;
import com.java.customer.entity.Customer;
import com.java.customer.repository.CustomerRepository;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
	
	private final CustomerRepository customerRepository;
    
    private final ModelMapper modelMapper;

	@Override
	public CustomerResponse saveCustomer(CustomerDto customerDto) {
        if(customerRepository.existsById(customerDto.getCustomerId())) {
            throw new CustomerIdExistsException("Customer id exists");
        }
		// TODO Auto-generated method stub
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return mapToResponse(savedCustomer);

        /*    Customer customer = new Customer();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setAddress(customerDto.getAddress());
        customerRepository.save(customer);*/
	}

	@Override
	public CustomerResponse updateCustomer(CustomerDto customerDto, long customerId) {
		// TODO Auto-generated method stub
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerIdNotExistsException("Customer id is not found"));

        /*if(returningCustomerId.isEmpty()) {
			throw new CustomerIdNotExistsException("Customer id is not found");
		}
		Customer customer = returningCustomerId.get();*/

        modelMapper.map(customerDto, customer);
        Customer updatedCustomer = customerRepository.save(customer);
        return mapToResponse(updatedCustomer);

		/*customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setAddress(customerDto.getAddress());*/
	}

	@Override
	public CustomerResponse findByCustomerId(long customerId) {
		// TODO Auto-generated method stub
		Customer returningCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerIdNotExistsException("Customer id is not found"));
        return mapToResponse(returningCustomer);

        /*if(returningCustomer.getCustomerId() != customerId) {
			throw new RuntimeException("");
		}
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(returningCustomer.getCustomerId());
        customerDto.setCustomerName(returningCustomer.getCustomerName());
        customerDto.setEmail(returningCustomer.getEmail());
        customerDto.setMobileNumber(returningCustomer.getMobileNumber());
        customerDto.setAddress(returningCustomer.getAddress());
        return customerDto;*/
        
		
//		return customerRepository.findById(customerId)
//		        .map(customer -> {
//		            CustomerDto customerDto = new CustomerDto();
//		            customerDto.setCustomerId(customer.getCustomerId());
//		            customerDto.setCustomerName(customer.getCustomerName());
//		            customerDto.setEmail(customer.getEmail());
//		            customerDto.setMobileNumber(customer.getMobileNumber());
//		            customerDto.setAddress(customer.getAddress());
//		            return customerDto;
//		        });
//		return customerRepository.findById(customerId).map(cutsomer -> {
//			
//			CustomerDto customerDto = new CustomerDto();
//			customerDto.setCustomerId(customerI)
			
//					CustomerDto customerDto = new CustomerDto();
//					customerDto.s
//					customerDto.setCustomerId(customer.getCustomerId());
//					customerDto.setCustomerName(customer.getCustomerName());
//					customerDto.setEmail(customer.getEmail());
//					customerDto.setMobileNumber(customer.getMobileNumber());
//					customerDto.setAddress(customer.getAddress());
//					return cutsomerDto;
					
				//});)
		
	}

	@Override
	public List<CustomerResponse> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> all = customerRepository.findAll();
		if(all.isEmpty()) {
			throw new CustomersNotFoundException("customer not found");
		}
        return all.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
	}

	@Override
	public String deleteCustomerById(long customerId) {
		// TODO Auto-generated method stub
        Customer customerIdIsNotFound = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerIdNotExistsException("Customer id is not found"));
        customerRepository.deleteById(customerIdIsNotFound.getCustomerId());
        return "Customer deleted with : " +customerId;
	}

	@Override
	public String deleteAllCustomers() {
		// TODO Auto-generated method stub
        List<Customer> allCustomers = customerRepository.findAll();
        if(allCustomers.isEmpty()) {
            throw new CustomersNotFoundException("customer not found");
        }
        customerRepository.deleteAll();

		return "Customers deleted";
	}


    private CustomerResponse mapToResponse(Customer customer) {
        return modelMapper.map(customer, CustomerResponse.class);
    }
}
