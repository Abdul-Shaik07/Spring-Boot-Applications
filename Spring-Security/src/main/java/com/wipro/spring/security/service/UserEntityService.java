package com.wipro.spring.security.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.spring.security.entity.UserEntity;
import com.wipro.spring.security.repository.UserEntityRepository;

@Service
public class UserEntityService implements IUserEntityService {
	@Autowired
	UserEntityRepository userRepository;

	@Autowired
	JwtService jwtService;
	//@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public UserEntity addUserEntity(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		return userRepository.save(userEntity);
	}

	@Override
	public List<UserEntity> findAllUserEntity() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserEntity findUserEntityById(long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public String login(UserEntity userEntity) {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken token 
				= new UsernamePasswordAuthenticationToken(userEntity.getUserName(), userEntity.getPassword());

		Authentication authenticate = authenticationManager.authenticate(token);
		boolean authenticated = authenticate.isAuthenticated();
		if(authenticated) {
			String jwtToken = jwtService.generateToken(userEntity.getUserName());
			return jwtToken;
		} else {
			throw new RuntimeException("Invalid Credentials");
		}

	}
	
	

}
