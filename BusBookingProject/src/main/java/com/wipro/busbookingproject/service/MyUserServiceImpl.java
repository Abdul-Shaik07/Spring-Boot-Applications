
package com.wipro.busbookingproject.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.stereotype.Service;

import com.wipro.busbookingproject.entity.MyUser; 
import com.wipro.busbookingproject.repository.MyUserRepository;

@Service 
public class MyUserServiceImpl implements IMyUserService {

	@Autowired 
	MyUserRepository myUserRepository;


	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override 
	public MyUser saveUser(MyUser myUser) {
	
		myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
		myUserRepository.save(myUser); 
		return myUser; 
	}
	 }

