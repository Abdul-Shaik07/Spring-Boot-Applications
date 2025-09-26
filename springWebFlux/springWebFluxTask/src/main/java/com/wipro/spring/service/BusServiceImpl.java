package com.wipro.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.ExecuteFunction;
import org.springframework.stereotype.Service;

import com.wipro.spring.entity.Bus;
import com.wipro.spring.repository.BusRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BusServiceImpl implements IBusService {
	
	@Autowired
	BusRepository busRepository;
	@Autowired
	DatabaseClient databaseClient;
	
	@Override
	public Mono<Bus> insert(Bus bus) {
		// TODO Auto-generated method stub
		return (Mono<Bus>) this.databaseClient.sql("insert into bus_info(busId, busName, ticketId, ticketPrice, departureDate, arrivalDate, mobileNumber) values (:busId, :busName, :ticketId, :ticketPrice, :departureDate, :arrivalDate, :mobileNumber)")
				.filter((statement, executeFunction) -> statement.returnGeneratedValues("bus").execute())
				.bind("busId", bus.getBusId())
				.bind("busName", bus.getBusName())
				.bind("ticketId", bus.getTicketId())
				.bind("ticketPrice", bus.getTicketPrice())
				.bind("departureDate", bus.getDepartureDate())
				.bind("arrivalDate", bus.getArrivalDate())
				.bind("mobileNumber", bus.getMobileNumber())
				.fetch()
				.first()
				.map(rows -> bus);	
	}

	@Override
	public Mono<Object> update(long busId, Bus bus) {
		// TODO Auto-generated method stub
		return this.databaseClient.sql("UPDATE bus_info SET ticketPrice = :ticketPrice WHERE busId = :busId")
				.filter((statement, executeFunction) -> statement.returnGeneratedValues("bus").execute())
				.bind("busId", busId)
				.bind("busName", bus.getBusName())
				.bind("ticketId", bus.getTicketId())
				.bind("ticketPrice", bus.getTicketPrice())
				.bind("departureDate", bus.getDepartureDate())
				.bind("arrivalDate", bus.getArrivalDate())
				.bind("mobileNumber", bus.getMobileNumber())
				.fetch()
				.first()
				.map((r) -> {return bus;});	
	}

	@Override
	public Mono<Bus> findBusById(long busId) {
		// TODO Auto-generated method stub
		return busRepository.findById(busId);
	}

	

	@Override
	public Mono<String> deleteBusById(long busId) {
		// TODO Auto-generated method stub
		return busRepository.deleteById(busId).then(Mono.just("Record Deleted : " +busId));
		
		
	}


	@Override
	public List<Flux<Bus>> findAllBuses() {
		// TODO Auto-generated method stub
		return (List<Flux<Bus>>) busRepository.findAll();
	}

}
