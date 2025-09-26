package com.wipro.busbookingproject.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wipro.busbookingproject.entity.MyUser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
	@Autowired
	MyUser myUser;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" +myUser.getRoles()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return myUser.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return myUser.getUserName();
	}
	

}
