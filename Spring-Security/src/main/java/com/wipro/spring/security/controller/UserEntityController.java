package com.wipro.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.spring.security.entity.UserEntity;
import com.wipro.spring.security.service.IUserEntityService;

@RestController
@RequestMapping("/api/userEntity")
public class UserEntityController {
	
	@Autowired
	IUserEntityService iUserEntityService;
	
	@GetMapping("/public/getHello")
	public String hello() {
		return "<h1 style='background-color: red'>Welcome to Spring Security</h1>";
	}
	
	@PostMapping("/public/saveUser")
	public UserEntity addUserEntity(@RequestBody UserEntity userEntity) {
		
		return iUserEntityService.addUserEntity(userEntity);
	}

	@GetMapping("/user/findAllUserEntity")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<UserEntity> findAllUserEntity() {
		
		return iUserEntityService.findAllUserEntity();
	}
	
	@GetMapping("/admin/findUserEntityById/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public UserEntity findUserEntityById(@PathVariable long userId) {
		
		return iUserEntityService.findUserEntityById(userId);
	}
	
	@PostMapping("/public/login")
	public ResponseEntity<String> login(@RequestBody UserEntity userEntity) {
		return new ResponseEntity<String>(iUserEntityService.login(userEntity), HttpStatus.OK);
	}

}
