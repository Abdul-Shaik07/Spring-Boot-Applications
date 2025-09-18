package com.fitness.activityservice.service;


import java.util.List;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.response.ActivitiesWithUserId;
import com.fitness.activityservice.response.ActivityResponse;

public interface IActivityService {
	
	ActivityResponse registerActivity(ActivityDto activityDto);
	
	ActivityResponse getActivityById(String activityId);
    
    List<ActivityResponse> getAllActivities();
    ActivitiesWithUserId getActivitiesByUserId(Integer userId);

  
}

