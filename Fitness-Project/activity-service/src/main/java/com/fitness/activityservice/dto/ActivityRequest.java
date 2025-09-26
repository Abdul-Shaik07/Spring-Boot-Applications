package com.fitness.activityservice.dto;

import com.fitness.activityservice.model.ActivityType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {

    @NotNull(message = "user id should not be null")
    @Positive(message = "user id must be in positive number")
    private Integer userId;

    @NotNull(message = "activity type must not be null")
    private ActivityType activityType;

    @NotNull(message = "duration must not be null")
    @Positive(message = "duration must be a positive number")
    private Long duration;

    @NotNull(message = "calories burned must not be null")
    @PositiveOrZero(message = "calories burned must be zero or positive")
    private Long caloriesBurned;

    @NotNull(message = "start time must not be null")
    @FutureOrPresent(message = "start time cannot be in the future")
    private LocalDateTime startTime;

    private Map<String, Object> additionalMetrics;

}
