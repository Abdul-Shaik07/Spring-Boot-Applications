package com.java.orders.service;
import java.util.List;
import com.java.orders.dto.Orderdto;
import com.java.orders.response.OrderDetailsWithCustomerAndProducts;
import com.java.orders.response.OrderResponse;
import com.java.orders.response.ResponseOfCustomerWithOrder;

public interface IOrderService {
	
	OrderResponse saveOrder(Orderdto orderdto);
	OrderResponse updateOrder(Orderdto orderdto, long orderId);
	OrderResponse findByOrderId(long orderId);
	List<OrderResponse> findAllOrders();
	String deleteByOrderId(long orderId);
	String deleteAllOrders();
    OrderDetailsWithCustomerAndProducts getOrderDetails(long orderId);
	ResponseOfCustomerWithOrder getCustomerDetailsWithOrderId(long orderId);
}
