
 package com.wipro.busbookingproject.configuration;
 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.context.annotation.Bean; 
 import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain; 
 
 
 @Configuration
 @EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
 public class BusConfig {
 
	 @Autowired 
	 private UserDetailsService userDetailsService;
	
	 @Bean
	 public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
	     return httpSecurity
	         .csrf(csrf -> csrf.disable())
	         .authorizeHttpRequests(auth -> auth
	             .requestMatchers("/api/myUser/public/**").permitAll()
	             .requestMatchers("/admin/**").hasRole("ADMIN")
	             .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
	             .anyRequest().authenticated()
	         )
	         .formLogin(Customizer.withDefaults())
	         .httpBasic(Customizer.withDefaults())
	         .build();
	 }
	 
	 
	 @Bean 
	 public AuthenticationProvider getAuthenticationProvider() {
			 DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
			 daoAuthenticationProvider.setUserDetailsService(userDetailsService);
			 daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
			 return daoAuthenticationProvider; 
			 }
 
 }
 
