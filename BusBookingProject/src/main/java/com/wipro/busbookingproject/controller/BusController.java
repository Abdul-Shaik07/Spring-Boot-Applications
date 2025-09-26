package com.wipro.busbookingproject.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.busbookingproject.entity.Bus;
import com.wipro.busbookingproject.service.IBusService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/bus")
public class BusController {
	@Autowired
	IBusService iBusService;
	
	@PostMapping("/admin/insert")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Bus> insertBus(@Valid @RequestBody Bus bus, BindingResult result) {
		if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        result.getFieldErrors().forEach(error -> {
	            errors.put(error.getField(), error.getDefaultMessage());
	        });
	        return new ResponseEntity<Bus>((Bus) errors, HttpStatus.BAD_REQUEST);
	    }
		
		
		return new ResponseEntity<Bus>(iBusService.insertBus(bus), HttpStatus.OK);
	}
	
	@GetMapping("/user/findByTicketId/{busId}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Optional<Bus>> findByTicketId(@PathVariable long busId) {
	
		//Bus byTicketId = iBusService.findByTicketId(busId);
	
			return new ResponseEntity<Optional<Bus>>(iBusService.findByTicketId(busId), HttpStatus.OK);
	}

	@GetMapping("/user/findByTicketPriceGreaterThan/{ticketPrice}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<Bus>> findByTicketPriceGreaterThan(@PathVariable double ticketPrice) {
	
		//List<Bus> byTicketPriceGreaterThan = iBusService.findByTicketPriceGreaterThan(ticketPrice);
		
		
			return new ResponseEntity<List<Bus>>(iBusService.findByTicketPriceGreaterThan(ticketPrice), HttpStatus.OK);
	}

	@GetMapping("/user/findAllBuses")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity< List<Bus>> findAllBuses() {
		// TODO Auto-generated method stub
		//List<Bus> allBuses = iBusService.findAllBuses();
		return new ResponseEntity<List<Bus>>(iBusService.findAllBuses(), HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/delete/{busId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteById(@PathVariable long busId) {
		
		//Bus byTicketId = iBusService.findByTicketId(busId);
		
			return new ResponseEntity<String>(iBusService.deleteById(busId), HttpStatus.OK);
	}
	
	@PutMapping("/admin/updateBus/{busId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Bus> updateBus(@RequestBody @Valid Bus bus, @PathVariable long busId) {		
		return new ResponseEntity<Bus>(iBusService.updateBus(bus, busId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/user/findAllBusesBasedOnSort")
	public ResponseEntity<List<Bus>> findAllBusesBasedOnSort() {
		return new ResponseEntity<List<Bus>>(iBusService.findAllBusesBasedOnSort(), HttpStatus.OK);
	}

}
