package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.response.ActivityResponse;

import java.util.List;

public interface IActivityService {
    ActivityResponse registerActivity(ActivityRequest activityRequest);

    ActivityResponse getByActivityId(String activityId);

    List<ActivityResponse> getAllActivities();
}
