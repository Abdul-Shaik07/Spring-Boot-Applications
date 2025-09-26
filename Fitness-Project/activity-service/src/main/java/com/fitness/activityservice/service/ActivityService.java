package com.fitness.activityservice.service;

import com.fitness.activityservice.client.UserClient;
import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.exception.ActivitiesNotFoundException;
import com.fitness.activityservice.exception.ActivityIdNotFoundException;
import com.fitness.activityservice.exception.UserIdNotFoundException;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRepository;
import com.fitness.activityservice.response.ActivityResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService implements IActivityService{

    private final ActivityRepository activityRepository;
    private final ModelMapper modelMapper;
    private final UserClient userClient;
    private final KafkaTemplate<String, Activity> kafkaTemplate;
    @Value("${kafka.topic.name}")
    private String topicName;

    @Override
    public ActivityResponse registerActivity(ActivityRequest activityRequest) {

        Boolean exists = userClient.fetchUserByIdValidate(activityRequest.getUserId());
        if(!exists){
            throw new UserIdNotFoundException("user id not found");
        }
        Activity activity = modelMapper.map(activityRequest, Activity.class);
        Activity savedActivity = activityRepository.save(activity);
        try{
            kafkaTemplate.send(topicName, String.valueOf(savedActivity.getUserId()), savedActivity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapToResponse(savedActivity);
    }

    @Override
    public ActivityResponse getByActivityId(String activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityIdNotFoundException("activity id not found"));
       return mapToResponse(activity);
    }

    @Override
    public List<ActivityResponse> getAllActivities() {
        List<Activity> allActivities = activityRepository.findAll();
        if(allActivities.isEmpty()) {
            throw new ActivitiesNotFoundException("activities not found");
        }
        return allActivities.stream()
                .map(this::mapToResponse)
                .toList();

    }

    private ActivityResponse mapToResponse(Activity activity) {
        return modelMapper.map(activity, ActivityResponse.class);
    }
}
