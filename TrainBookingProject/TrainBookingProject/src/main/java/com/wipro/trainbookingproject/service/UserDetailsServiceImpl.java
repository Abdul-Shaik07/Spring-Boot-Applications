package com.wipro.trainbookingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.trainbookingproject.entity.MyUser;
import com.wipro.trainbookingproject.entity.Train;
import com.wipro.trainbookingproject.repository.MyUserRepository;
import com.wipro.trainbookingproject.repository.TrainRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	MyUserRepository myUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser byName = myUserRepository.findByUserName(username);
		
		if(byName == null) {
			throw new UsernameNotFoundException("username is not found");
		}
		return new UserDetailsImpl(byName);
	}
	
	
	

}
