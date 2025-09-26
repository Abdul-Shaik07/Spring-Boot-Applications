package com.java.springsecurity.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.springsecurity.Entity.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
	
	Optional<MyUser> findByUserName(String username);

}
