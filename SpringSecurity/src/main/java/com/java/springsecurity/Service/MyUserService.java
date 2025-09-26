package com.java.springsecurity.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.springsecurity.Entity.MyUser;
import com.java.springsecurity.Repository.MyUserRepository;
@Service
public class MyUserService implements UserDetailsService {
	
	@Autowired
	private MyUserRepository myUserRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> user = myUserRepository.findByUserName(username);
		if(user.isPresent()) {
			var userObj = user.get();
			System.out.println("Hello");
			return User.builder()
					.username(userObj.getUsername())
					.password(userObj.getPassword())
					.roles(getRoles(userObj)).build();
		}
		return null;
		
	}

	private String[] getRoles(MyUser userObj) {
		if(userObj.getRole() == null) {
			System.out.println("Hello");
			return new String[] {"USER"};
			
		}
		return userObj.getRole().split(",");
		
	}

	

	

}
