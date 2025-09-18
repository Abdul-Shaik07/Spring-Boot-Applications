package com.java.orders.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.java.orders.entity.Order;
import com.java.orders.entity.OrderDetails;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderResponse {
    private Long orderId;
    private Long customerId;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<OrderDetailsResponse> orderDetailsResponse;
}
