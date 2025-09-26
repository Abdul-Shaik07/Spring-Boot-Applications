package com.wipro.trainbookingproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.wipro.trainbookingproject.Dto.TrainRequestDto;
import com.wipro.trainbookingproject.Dto.TrainResponseDto;

public interface ITrainService {
	
	TrainResponseDto insertTrain(TrainRequestDto trainRequestDto);
	
	TrainResponseDto updateTrain(TrainRequestDto Dto, long trainNumber);
	
	Optional<TrainResponseDto> findTrainById(long trainNumber);
	
	String deleteTrainById(long trainNumber);
	
	List<TrainResponseDto> findAllTrains();
	
	Page<TrainResponseDto> findAllTicketsPagination(int page, int size);	
	
	

}
