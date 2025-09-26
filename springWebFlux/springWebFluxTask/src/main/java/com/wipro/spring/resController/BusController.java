package com.wipro.spring.resController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.spring.entity.Bus;
import com.wipro.spring.service.IBusService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bus")
public class BusController {
	@Autowired
	IBusService iBusService;
	
	@PostMapping("/insert")
	public Mono<Bus> insert(@RequestBody Bus bus) {
		
		return iBusService.insert(bus);	
	}
	
	@PutMapping("/update/{busId}")
	public Mono<Object> update(@PathVariable long busId, @RequestBody Bus bus) {
		return iBusService.update(busId, bus);
	}
	
	
	@GetMapping("/findBusById/{busId}")
	public Mono<Bus> findBusById(@PathVariable long busId) {
		// TODO Auto-generated method stub
		return iBusService.findBusById(busId);
	}
	
	@GetMapping("/findAllBuses")
	public List<Flux<Bus>> findAllBuses() {
		
		return iBusService.findAllBuses();
		
	}

	@DeleteMapping("/delete/{busId}")
	public Mono<String> deleteBusById(@PathVariable long busId) {
		// TODO Auto-generated method stub
		return iBusService.deleteBusById(busId);
	
	}
}
