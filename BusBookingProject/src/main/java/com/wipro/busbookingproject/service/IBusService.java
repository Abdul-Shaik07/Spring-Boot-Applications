package com.wipro.busbookingproject.service;

import java.util.List;
import java.util.Optional;

import com.wipro.busbookingproject.entity.Bus;

public interface IBusService {
	
	Bus insertBus(Bus bus);
	
	Bus updateBus(Bus bus, long busId);
	
	Optional<Bus> findByTicketId(long busId);
	
	List<Bus> findByTicketPriceGreaterThan(double ticketPrice);
	
	List<Bus> findAllBuses();
	
	List<Bus> findAllBusesBasedOnSort();
	
	String deleteById(long busId);
	
	String deleteAllBuses();

	

}
