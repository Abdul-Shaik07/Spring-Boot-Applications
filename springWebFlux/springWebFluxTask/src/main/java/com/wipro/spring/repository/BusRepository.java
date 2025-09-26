package com.wipro.spring.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.spring.entity.Bus;


@Repository
public interface BusRepository extends ReactiveCrudRepository<Bus, Long>{

}
