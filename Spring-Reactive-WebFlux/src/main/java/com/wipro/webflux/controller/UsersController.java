package com.wipro.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.webflux.entity.User;
import com.wipro.webflux.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	IUserService service;
	
	
	//@ResponseStatus(HttpStatus.FOUND)
	 @GetMapping("/getall")
	    public ResponseEntity<Flux<User>> getAllUsers() {
	        
		 	Flux<User> allUsers = service.getAllUsers();
		 	if(allUsers != null ) {
		 		return new ResponseEntity<Flux<User>>(allUsers, HttpStatus.FOUND);
		 	}
		 	return new ResponseEntity<Flux<User>>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/getbyid/{id}")
	    public Mono<User> getUserById(@PathVariable Long id) {
	        Mono<User> userById = service.getUserById(id);
	        
	        return userById;
	    }
	    

	    @PostMapping("/create")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Mono<User> createUser(@RequestBody User user) {
	        return  service.createUser(user);
	    }
	    
	    @PutMapping("/update/{id}")
	    public Mono<User> updateUser( @PathVariable  long id ,@RequestBody User user ) {
	        return  service.updateUser(id,user);
	    }

	    

	    @GetMapping("/name/{name}")
	    public Flux<User> getUsersByName(@PathVariable String name) {
	        return service.getUsersByName(name);
	    }
	
	
	

}
