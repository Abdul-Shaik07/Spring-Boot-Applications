package com.fitness.activityservice.response;

import com.fitness.activityservice.model.ActivityType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityResponse {

    private String activityId;
    //private Integer userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
