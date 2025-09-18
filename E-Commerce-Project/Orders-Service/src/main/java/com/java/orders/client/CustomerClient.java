package com.java.orders.client;

import com.java.orders.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {
	@GetMapping("/customers/api/findByCustomerId/{customerId}")
    CustomerResponse findByCustomerId(@PathVariable("customerId") long customerId);

}
