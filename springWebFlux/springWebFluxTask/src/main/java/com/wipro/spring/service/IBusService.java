package com.wipro.spring.service;

import java.util.List;

import com.wipro.spring.entity.Bus;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusService {
	
	
	
	Mono<Bus> insert(Bus bus);
	
	
	Mono<Bus> findBusById(long busId);
	
	List<Flux<Bus>> findAllBuses();
	
	Mono<String> deleteBusById(long busId);

	Mono<Object> update(long busId, Bus bus);
	
	

}
