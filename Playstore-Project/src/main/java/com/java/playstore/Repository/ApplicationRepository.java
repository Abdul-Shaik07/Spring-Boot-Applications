package com.java.playstore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.playstore.Entity.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {

    List<Application> findByName(String name);

}
