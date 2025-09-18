package com.java.orders.dto;


import com.java.orders.entity.Order;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDto {
	
	
//	@NotNull(message = "Order details id should not be null")
//	@Positive(message = "Order details ID must be positive")
//	private Long orderDetailsId;
	@NotNull(message = "orderId should not be null")
	@Positive(message = "Order Id must be positive")
	private Long orderId;
	@NotNull(message = "product id should not be null")
	@Positive(message = "Order details ID must be positive")
	private long productId;
	@NotNull(message = "price should not be null")
	@DecimalMin(value = "1.00", message = "price should be more than or equal to 1")
	@DecimalMax(value = "5000.43", message = "price should be less than or equal to 5000.43")
	private double price;
	@NotNull(message = "delivery date should not be null")
	@Min(value = 1, message = "quantity should be more than or equal to 1")
	@Max(value = 100, message = "quantity should be less than or equal to 100")
	private long quantity;
}
