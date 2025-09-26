package com.wipro.trainbookingproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.internal.bytebuddy.asm.Advice.OffsetMapping.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wipro.trainbookingproject.Dto.TrainRequestDto;
import com.wipro.trainbookingproject.Dto.TrainResponseDto;
import com.wipro.trainbookingproject.entity.Train;
import com.wipro.trainbookingproject.repository.TrainRepository;
@Service
public class TrainServiceImpl implements ITrainService {
	@Autowired
	private TrainRepository trainRepository;
	
	@Autowired
	private org.modelmapper.ModelMapper modelMapper;

	@Override
	public TrainResponseDto insertTrain(TrainRequestDto trainRequestDto) {
		// TODO Auto-generated method stub
		
		Train train = modelMapper.map(trainRequestDto, Train.class);
		
		Train save = trainRepository.save(train);
		
		TrainResponseDto trd = modelMapper.map(save, TrainResponseDto.class);
		
		return trd;
	}

	@Override
	public TrainResponseDto updateTrain(TrainRequestDto trainRequestDto, long trainNumber) {
		// TODO Auto-generated method stub
		Optional<Train> byId = trainRepository.findById(trainNumber);
		if(byId.isEmpty()) {
			throw new RuntimeException("Train Number is not found to update");
		}
		
		Train train = byId.get();
		modelMapper.map(trainRequestDto, train);
		Train update = trainRepository.save(train);
		TrainResponseDto trd = modelMapper.map(update, TrainResponseDto.class);
		return trd;
	}

	@Override
	public Optional<TrainResponseDto> findTrainById(long trainNumber) {
		// TODO Auto-generated method stub
		Optional<Train> byId = trainRepository.findById(trainNumber);
		if(byId.isEmpty()) {
			throw new RuntimeException("Train Number is not found to update");
		}
		Train train = byId.get();
		TrainResponseDto trd = modelMapper.map(train, TrainResponseDto.class);
		return Optional.of(trd);
	}

	@Override
	public String deleteTrainById(long trainNumber) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<TrainResponseDto> findAllTrains() {
		// TODO Auto-generated method stub
		List<Train> all = trainRepository.findAll();
		//List<TrainResponseDto> trd = new ArrayList<>();
		if(all.isEmpty()) {
			throw new RuntimeException("Train Data is not found");
		}
		
		return all.stream().map(train -> modelMapper.map(train, TrainResponseDto.class)).collect(Collectors.toList());
		
		
		
	}

	@Override
	public Page<TrainResponseDto> findAllTicketsPagination(int page, int size) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Train> all = trainRepository.findAll(pageRequest);
		Page<TrainResponseDto> map = all.map(train -> modelMapper.map(train, TrainResponseDto.class));
		return map;
	}
	
}