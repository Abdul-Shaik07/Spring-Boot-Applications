package com.wipro.spring.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.spring.webflux.entity.User;
import com.wipro.spring.webflux.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@PostMapping("/insert")
	public ResponseEntity<Mono<User>> insertUser(@RequestBody User user) {
		Mono<User> insertUser = iUserService.insertUser(user);
		if(insertUser != null) {
			return new ResponseEntity<Mono<User>>(HttpStatus.OK);
		}
		return new ResponseEntity<Mono<User>>(insertUser, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findUserById/{id}")
	public ResponseEntity<Mono<User>> findUserById(@PathVariable int id) {
		Mono<User> userById = iUserService.findUserById(id);
		if(userById != null) {
			return new ResponseEntity<Mono<User>>(userById, HttpStatus.OK);
		}
		return new ResponseEntity<Mono<User>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findAllUsers")
	public ResponseEntity<Flux<User>> findAllUsers() {
		
		Flux<User> allUsers = iUserService.findAllUsers();
		
		if(allUsers != null) {
			return new ResponseEntity<Flux<User>>(allUsers, HttpStatus.OK);
		}
		
		return new ResponseEntity<Flux<User>>(HttpStatus.NOT_FOUND);
		
		
	}

}
