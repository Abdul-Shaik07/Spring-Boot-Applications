package com.wipro.busbookingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.busbookingproject.entity.MyUser;
import com.wipro.busbookingproject.repository.MyUserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	MyUserRepository myUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser byUserName = myUserRepository.findByUserName(username);
		if(byUserName == null) {
			throw new UsernameNotFoundException("Username is not there to fetch");
		}
		return new UserDetailsImpl(byUserName);
	}

}
