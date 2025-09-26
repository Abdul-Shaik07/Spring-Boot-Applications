package com.wipro.trainbookingproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.trainbookingproject.Dto.TrainRequestDto;
import com.wipro.trainbookingproject.Dto.TrainResponseDto;
import com.wipro.trainbookingproject.entity.Train;
import com.wipro.trainbookingproject.exception.DeleteIdNotFoundException;
import com.wipro.trainbookingproject.exception.TrainIdNotFoundException;
import com.wipro.trainbookingproject.service.ITrainService;
@RestController
@RequestMapping("/api/trains")
public class TrainController {
	
	@Autowired
	ITrainService iTrainService;
	
	@PostMapping("/admin/insertTrain")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TrainResponseDto> insertTrain(@RequestBody TrainRequestDto trainRequestDto) {
		
		TrainResponseDto insertTrain = iTrainService.insertTrain(trainRequestDto);
	
			return new ResponseEntity<TrainResponseDto>(insertTrain, HttpStatus.OK);
	}

	@PutMapping("/admin/update/{trainNumber}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TrainResponseDto> updateTrain(@RequestBody TrainRequestDto trainRequestDto, @PathVariable("trainNumber") long trainNumber) {
		
		return new ResponseEntity<TrainResponseDto>(iTrainService.updateTrain(trainRequestDto, trainNumber), HttpStatus.OK);
		
	}

	@GetMapping("/user/findTrainById/{trainNumber}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Optional<TrainResponseDto>> findTrainById(@PathVariable("trainNumber") long trainNumber) throws TrainIdNotFoundException {
		
		return new ResponseEntity<Optional<TrainResponseDto>>(iTrainService.findTrainById(trainNumber), HttpStatus.OK);
		
	
	}

	@DeleteMapping("/admin/delete/{trainNumber}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteTrainById(@PathVariable("trainNumber") long trainNumber) throws DeleteIdNotFoundException {
		
			Optional<TrainResponseDto> trainById = iTrainService.findTrainById(trainNumber);
			if(trainById != null) {
				iTrainService.deleteTrainById(trainNumber);
				return new ResponseEntity<String>("Record Deleted", HttpStatus.OK);
			} else {
				throw new TrainIdNotFoundException("Id is not found to delete");
			}
	}

	@GetMapping("/user/findAllTrains")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<TrainResponseDto>> findAllTrains() {
		
		return new ResponseEntity<List<TrainResponseDto>>(iTrainService.findAllTrains(), HttpStatus.OK);
		
		//List<Train> allTrains = iTrainService.findAllTrains();
	}	
	
	@GetMapping("/user/pageable/findAllTicketsPagination")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Page<TrainResponseDto>> findAllTicketsPagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue =  "2") int size) {
		return new ResponseEntity<Page<TrainResponseDto>>(iTrainService.findAllTicketsPagination(page, size), HttpStatus.OK);
	}

}
