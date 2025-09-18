package com.java.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
	
	private long customerId;
	@NotBlank(message = "customer name should not be blank")
	@Size(min = 1, max = 100, message = "the customer name characters should be more than equal to 1 "
			+ "and less than euql to 100")
	private String customerName;
	@NotBlank(message = "email should not be blank")
	@Email
	private String email;
	@NotBlank(message = "mobile number should not be blank")
	@Pattern( regexp = "^\\+91-[6-9]\\d{9}$",
	        message = "Mobile number must be in format +91-XXXXXXXXXX and start with 6-9")
	private String mobileNumber;
	@NotBlank(message = "address should not be blank")
	@Size(min = 1, max = 100, message = "the address characters should be more than equal to 1 "
			+ "and less than euql to 100")
	private String address;

}
