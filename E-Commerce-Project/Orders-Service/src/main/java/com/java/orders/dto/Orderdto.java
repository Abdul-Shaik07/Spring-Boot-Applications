package com.java.orders.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orderdto {
//	@NotNull(message = "Order id should not be null")
//	private Long orderId;
	@NotBlank(message = "customer name should not be blank")
	@Size(min = 1, max = 100)
	private Long customerId;
	@NotNull(message = "order date should not be null")
	@PastOrPresent(message = "order date should not be future")
	private LocalDate orderDate;
	@NotNull(message = "delivery date should not be null")
	@FutureOrPresent(message = "delivery date should not be past")
	private LocalDate deliveryDate;
	@NotNull(message = "order details should not be null")
	private List<OrderDetailsDto> orderDetails;

}
