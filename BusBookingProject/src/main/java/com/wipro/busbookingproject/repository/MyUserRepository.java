package com.wipro.busbookingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.busbookingproject.entity.MyUser;
@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
	
	MyUser findByUserName(String userName);

}
