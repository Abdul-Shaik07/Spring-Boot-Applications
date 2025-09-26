//package com.wipro.spring.security.service;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.wipro.spring.security.entity.UserEntity;
//
//public class UserDetailsImpl implements UserDetails {
//	@Autowired
//	UserEntity userEntity;
//	
//	public UserDetailsImpl(UserEntity userEntity) {
//		super();
//		this.userEntity = userEntity;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return Collections.singleton(new SimpleGrantedAuthority("USER"));
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return userEntity.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		
//		return userEntity.getUserName();
//	}
//
//}
