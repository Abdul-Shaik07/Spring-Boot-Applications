package com.java.mappings.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.mappings.Entity.Orders;
import com.java.mappings.Service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/saveOrder")
	public Orders saveOrder(@RequestBody Orders orders) {
		System.out.println("ORDERS");
		return orderService.saveOrder(orders);
	}
	
	@PutMapping("/updateOrder/{id}")
	public Orders updateOrders(@RequestBody Orders orders, @PathVariable long id) {
		return orderService.updateOrders(orders, id);
	}
	
	@GetMapping("/findAllOrders")
	public List<Orders> findAllOrder() {
		return orderService.findAllOrders();
	}
	@GetMapping("/findOrdersById/{id}")
	public Optional<Orders> findById(@PathVariable long id) {
		return orderService.findById(id);
	}
	
	@GetMapping("/findOrdersByName/{name}")
	public List<Orders> findByName(@PathVariable String name) {
		return orderService.findByName(name);
	}
}
