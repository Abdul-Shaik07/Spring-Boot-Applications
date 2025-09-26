package com.wipro.spring.security.configuration;

import java.util.ArrayList;
import java.util.List;

import com.wipro.spring.security.filter.JwtAuthFilter;
import com.wipro.spring.security.service.UserDetailsServiceImpl;
import com.wipro.spring.security.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	JwtAuthFilter jwtAuthFilter;

	public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}
	
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/userEntity/public/**").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/user/**").hasAnyRole("USER","ADMIN").anyRequest().authenticated())
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authenticationProvider(getAuthenticationProvider())
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				.formLogin(Customizer.withDefaults())
				  .httpBasic(Customizer.withDefaults())
				  .build();
		
				
				
//				httpSecurity.csrf().disable()
//						   .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/api/userEntity/public/**").permitAll()
//								   				  .requestMatchers("/admin/**").hasRole("ADMIN")
//								   				  .requestMatchers("/user/**").hasAnyRole("USER, ADMIN")
//								   				  .anyRequest().authenticated())
//												  .formLogin(Customizer.withDefaults())
//												  .httpBasic(Customizer.withDefaults())
//												  .build();
		
	}
	
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
		//daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daoAuthenticationProvider;
	}
	
	
	@Bean
	public static AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	
	
	
//	@Bean
//	protected UserDetailsService getUserDetailsService() {
//		
//		List<UserDetails> list = new ArrayList<UserDetails>();
//		
//		list.add(User.withDefaultPasswordEncoder().username("abdulabbu07").password("abbu123").roles("USER").build());
//		
//		list.add(User.withDefaultPasswordEncoder().username("admin123").password("admin123").roles("ADMIN").build());
//		
//		list.add(User.withDefaultPasswordEncoder().username("trainee123").password("trainee123").roles("TRAINEE").build());
//		
//		return new InMemoryUserDetailsManager(list);
//	}

}
