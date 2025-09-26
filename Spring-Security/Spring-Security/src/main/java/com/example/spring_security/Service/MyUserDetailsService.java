package com.example.spring_security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring_security.Entity.User;
import com.example.spring_security.Entity.UserPrincipal;
import com.example.spring_security.Repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if(user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("Unimplemented method 'loadUserByUsername'");
        }
        return new UserPrincipal(user);
    }
    public UserRepository getUserRepository() {
        return userRepository;
    }
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }   
}
