package com.fitness.activityservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fitness.activityservice.response.ActivitiesWithUserId;
import com.fitness.activityservice.response.UsersResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fitness.activityservice.client.UsersClient;
import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRepository;
import com.fitness.activityservice.response.ActivityResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService implements IActivityService {

    
    private final ActivityRepository activityRepository;
   
    private final ModelMapper modelMapper;
    
    private final KafkaTemplate<String, Activity> kafkaTemplate;

    
    //private final UserValidationService userValidationService;
    private final UsersClient usersClient;
    
    @Value("${kafka.topic.name}")
    private String topicName;

    @Override
    public ActivityResponse registerActivity(ActivityDto activityDto) {
        //boolean isValidUserId = userValidationService.validateUser(activityDto.getUserId());
        Boolean isValidUserId = usersClient.fetchUsersByIdValidate(activityDto.getUserId());
        if (!isValidUserId) {
            throw new RuntimeException("User Id is not a valid");
        }
        Activity activity = modelMapper.map(activityDto, Activity.class);
       /* Activity activity = Activity.builder()
                .usersId(activityDto.getUsersId())
                .activityType(activityDto.getActivityType())
                .duration(activityDto.getDuration())
                .caloriesBurned(activityDto.getCaloriesBurned())
                .startTime(activityDto.getStartTime())
                .additionalMetrics(activityDto.getAdditionalMetrics())
                .build();*/
        Activity savedActivity = activityRepository.save(activity);
        try{
			kafkaTemplate.send(topicName, String.valueOf(savedActivity.getUserId()), savedActivity);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        if(savedActivity.getUserId() == 0) {
            throw new RuntimeException("Activity Id is null");
        }
        return mapToResponse(savedActivity);
    }
    
    @Override
	public ActivityResponse getActivityById(String activityId) {
		 Optional<Activity> returningActivityId = activityRepository.findById(activityId);
	        if(returningActivityId.isEmpty()) {
	            throw new RuntimeException("Activity Id is not found to fetch");
	        }
	        Activity activity = returningActivityId.get();
	        return mapToResponse(activity);
		
	}


    @Override
    public List<ActivityResponse> getAllActivities() {
        List<Activity> all = activityRepository.findAll();
        if(all.isEmpty()) {
            throw new RuntimeException("Activities are not found");
        }
        return all.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ActivitiesWithUserId getActivitiesByUserId(Integer userId) {

       /* List<Activity> byUserId = activityRepository.findByUserId(userId);
        if(byUserId.isEmpty()) {
            throw new RuntimeException("User Id is not found " +byUserId);
        } */


        UsersResponse usersResponse = usersClient.fetchUserById(userId);
        if(!usersResponse.getUserId().equals(userId)) {
            throw new RuntimeException("User Id is not found " +usersResponse.getUserId());
        }

        List<Activity> byUserId = activityRepository.findByUserId(userId);
        List<ActivityResponse> activityResponse = byUserId.stream()
                .map(this::mapToResponse)
                .toList();
        ActivitiesWithUserId activitiesWithUserId = new ActivitiesWithUserId();
        activitiesWithUserId.setUsersResponse(usersResponse);
        activitiesWithUserId.setActivitiesResponse(activityResponse);
        return activitiesWithUserId;
    }


    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse activityResponse = modelMapper.map(activity, ActivityResponse.class);
        return activityResponse;
    }

	
}
