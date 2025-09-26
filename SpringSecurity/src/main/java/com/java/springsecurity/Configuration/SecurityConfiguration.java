package com.java.springsecurity.Configuration;

import java.rmi.registry.Registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.java.springsecurity.Service.MyUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private MyUserService userDetailsService;
	
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(Customizer -> Customizer.disable())
				.authorizeHttpRequests(registry -> {
							registry.requestMatchers("/home/**", "/registration/**").permitAll();
							registry.requestMatchers("/myUser/**").hasAnyRole("USER");
							registry.requestMatchers("/admin/**").hasAnyRole("ADMIN");
							registry.anyRequest().authenticated();})
							.formLogin(Customizer.withDefaults()).build();
	}
	
//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		UserDetails userDetails = User.builder()
//				.username("Abbu")
//				.password("$2a$12$up2nkjTzHLtch/A7uA3OeuQQipJdmfEGhFduIPLE7Odb9Mr5qMF8O")
//				.roles("USER").build();
//		
//		UserDetails userDetails1 = User.builder()
//				.username("owner")
//				.password("$2a$12$2L1lSP9PUCxJnhFCCWY6rOdB4OtWSogSzosqswrxxw6MtsfFEtzua")
//				.roles("ADMIN", "USER").build();
//		return new InMemoryUserDetailsManager(userDetails, userDetails1);	
//	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}
	
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(getUserDetailsService());
		provider.setPasswordEncoder(getPasswordEncoder());
		return provider;
	}
	
	
	
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public UserDetailsService getDetailsService() {
//		UserDetails userDetails = User.builder()
//				.username("abbu")
//				.password(getPasswordEncoder().encode("1234"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(userDetails);		
//	}
//	@Bean
//	public SecurityFilterChain getSecurityFilterChain(HttpSecurity security) throws Exception{
//		return security
//				.authorizeHttpRequests(auth->auth
//				.requestMatchers("/home-page").permitAll()
//				.requestMatchers("/balance-details").authenticated())
//				.formLogin().		
//	}

}
