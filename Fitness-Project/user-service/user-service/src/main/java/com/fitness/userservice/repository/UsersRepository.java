package com.fitness.userservice.repository;

import com.fitness.userservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    boolean existsByEmail(String email);
}
