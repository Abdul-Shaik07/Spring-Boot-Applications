package com.java.mappings.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mappings.Entity.Address;
import com.java.mappings.Entity.Orders;
import com.java.mappings.Repository.OrderRepository;
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders saveOrder(Orders orders) {
		return orderRepository.save(orders);
	}

	
	public List<Orders> findAllOrders() {
		return orderRepository.findAll();
	}
	
	public Optional<Orders> findById(long id) {
		return orderRepository.findById(id);
	}

	
	public List<Orders> findByName(String name) {
		return orderRepository.findByName(name);
	}
	
	
	public Orders updateOrders(Orders orders, long id) {
			Optional<Orders> byId = orderRepository.findById(id);
			Orders orders2 = null;
			if(byId.isPresent()) {
				orders2 = byId.get();
				orders2.setName(orders.getName());
				orders2.setPrice(orders.getPrice());
				orders2.setQuantity(orders.getQuantity());
				
			}
			Address address = orders2.getAddress();
			Address address2 = orders.getAddress();
			
			if(address != null && address2 != null) {
				address.setName(address2.getName());
				address.setDoorNumber(address2.getDoorNumber());
				address.setStreetName(address2.getStreetName());
				address.setCity(address2.getCity());
				address.setState(address2.getState());
				address.setPincode(address2.getPincode());
		}
			return orderRepository.save(orders2);
	}

}
