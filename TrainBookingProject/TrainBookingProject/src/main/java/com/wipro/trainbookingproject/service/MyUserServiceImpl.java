package com.wipro.trainbookingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.trainbookingproject.entity.MyUser;
import com.wipro.trainbookingproject.repository.MyUserRepository;
@Service
public class MyUserServiceImpl implements IMyUserService {
	@Autowired
	MyUserRepository myUserRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public MyUser insertUser(MyUser myUser) {
		// TODO Auto-generated method stub
		myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
		
		return myUserRepository.save(myUser);
	}
	
	

}
