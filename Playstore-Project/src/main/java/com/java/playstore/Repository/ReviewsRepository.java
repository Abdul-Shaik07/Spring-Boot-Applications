package com.java.playstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.playstore.Entity.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
}
