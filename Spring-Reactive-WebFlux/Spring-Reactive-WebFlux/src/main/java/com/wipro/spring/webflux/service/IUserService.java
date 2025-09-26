package com.wipro.spring.webflux.service;

import com.wipro.spring.webflux.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
	
	
	Mono<User> insertUser(User user);
	
	Mono<User> findUserById(int id);
	
	Flux<User> findAllUsers();
	
	
	
	
	

}
