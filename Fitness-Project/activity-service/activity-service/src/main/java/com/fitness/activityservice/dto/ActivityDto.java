package com.fitness.activityservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fitness.activityservice.model.ActivityType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityDto {
    @NotNull(message = "userId is required")
    @Positive(message = "User Id must be at least 1 or more")
    private Integer userId;
    @NotNull(message = "activity type is required")
    private ActivityType activityType;
    @NotNull(message = "duration is required")
    @Positive(message = "duration is must be in positive format")
    private Integer duration;
    @NotNull(message = "calories burned is required")
    @Positive(message = "caloriesBurned must be in positive")
    private Integer caloriesBurned;
    @NotNull(message = "start time is required")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;
}
