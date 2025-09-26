package com.wipro.busbookingproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;


import com.wipro.busbookingproject.entity.Bus;
import com.wipro.busbookingproject.exceptionhandler.BusIdNotFoundException;
import com.wipro.busbookingproject.repository.BusRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Service
public class BusServiceImpl implements IBusService {
	@Autowired
	BusRepository busRepository;
	
	@Override
	public Bus insertBus(Bus bus) {
		return busRepository.save(bus);
	}
	
	@Override
	public Bus updateBus(Bus bus, long busId) {
		Optional<Bus> byId = busRepository.findById(busId);
		if(byId.isPresent()) {
			Bus bus2 = byId.get();
			bus2.setBusName(bus.getBusName());
			bus2.setTicketId(bus.getTicketId());
			bus2.setTicketPrice(bus.getTicketPrice());
			bus2.setDepartureDate(bus.getDepartureDate());
			bus2.setArrivalDate(bus.getArrivalDate());
			bus2.setMobileNumber(bus.getMobileNumber());
			return busRepository.save(bus2);	
		} else {
			throw new BusIdNotFoundException("Id is not found to update");
		}
	}

	@Override
	public Optional<Bus> findByTicketId(long busId) {
		
		log.info("finding the daya by busId");
		Optional<Bus> byId = busRepository.findById(busId);
		if(byId.isPresent()) {
			return byId;
		} else {
			throw new BusIdNotFoundException("Id is not found to fetch");
		}
	}

	@Override
	public List<Bus> findByTicketPriceGreaterThan(double ticketPrice) {
		
		// TODO Auto-generated method stub
		List<Bus> byTicketPriceGreaterThan = busRepository.findByTicketPriceGreaterThan(ticketPrice);
		if(byTicketPriceGreaterThan.isEmpty()) {
			return byTicketPriceGreaterThan;
		} else {
			throw new BusIdNotFoundException("Greather than price is not found compare to given value");
		}
	}
	
	@Override
	public List<Bus> findAllBusesBasedOnSort() {
		// TODO Auto-generated method stub
		Sort ascending = Sort.by("ticketPrice").ascending();
		List<Bus> all = busRepository.findAll(ascending);
		if(all.isEmpty()) {
			throw new BusIdNotFoundException("No records in the table");
		} else {
			return all;
		}
	}

	@Override
	public String deleteById(long busId) {
		
		Optional<Bus> byId = busRepository.findById(busId);
		if(byId.isPresent()) {
			busRepository.deleteById(busId);
			return "record deleted ";
		} else {
			throw new BusIdNotFoundException("Id is not found to delete");
		}
	}

	@Override
	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		List<Bus> all = busRepository.findAll();
		if(all.isEmpty()) {
			throw new BusIdNotFoundException("no records found to fetch");
		} else {
			return all;
		}
	}

	@Override
	public String deleteAllBuses() {
		// TODO Auto-generated method stub
		List<Bus> all = busRepository.findAll();
		if(all.isEmpty()) {
			throw new BusIdNotFoundException("no records found to delete all the records");
		} else {
			busRepository.deleteAll();
			return "All records deleted";
		}
	}

	
}

