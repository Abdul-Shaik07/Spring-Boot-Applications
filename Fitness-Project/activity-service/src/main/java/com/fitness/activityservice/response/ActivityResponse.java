package com.fitness.activityservice.response;

import com.fitness.activityservice.model.ActivityType;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;
@Data
public class ActivityResponse {
    private String activityId;
    private Integer userId;
    private ActivityType activityType;
    private Long duration;
    private Long caloriesBurned;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
