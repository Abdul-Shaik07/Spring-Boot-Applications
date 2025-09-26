package com.wipro.trainbookingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.trainbookingproject.Dto.TrainResponseDto;
import com.wipro.trainbookingproject.entity.Train;
@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
	
	

}
