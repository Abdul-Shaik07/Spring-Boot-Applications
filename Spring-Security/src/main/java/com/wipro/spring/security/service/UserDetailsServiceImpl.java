package com.wipro.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.spring.security.entity.UserEntity;
import com.wipro.spring.security.repository.UserEntityRepository;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserEntityRepository userEntityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity byUserName = userEntityRepository.findByUserName(username);

		if(byUserName == null) {
			throw new UsernameNotFoundException("Username is empty, fill something");
		}
		return new User(byUserName.getUserName(), byUserName.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_" +byUserName.getRoles())));
    }

}
