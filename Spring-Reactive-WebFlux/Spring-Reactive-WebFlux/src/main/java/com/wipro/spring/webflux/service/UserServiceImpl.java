package com.wipro.spring.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.spring.webflux.entity.User;
import com.wipro.spring.webflux.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements IUserService { 
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Mono<User> insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Mono<User> findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Flux<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
