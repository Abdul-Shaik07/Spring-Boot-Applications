package com.fitness.activityservice.factory;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.model.ActivityType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TestFactory {

    private static final AtomicInteger userIdCounter = new AtomicInteger(1);
    private static final Random random = new Random();

    // Factory method to generate a random ActivityDto
    public static ActivityDto createActivityDto() {
        ActivityDto dto = new ActivityDto();

        // Generate a valid userId
        dto.setUserId(userIdCounter.getAndIncrement());

        // Randomly select an ActivityType (assuming ActivityType is an enum)
        ActivityType[] types = ActivityType.values();
        dto.setActivityType(types[random.nextInt(types.length)]);

        // Generate positive duration (1-180 minutes)
        dto.setDuration(random.nextInt(180) + 1);

        // Generate positive calories burned (50-1000)
        dto.setCaloriesBurned(random.nextInt(951) + 50);

        // Generate startTime in the future or present
        dto.setStartTime(LocalDateTime.now().plusMinutes(random.nextInt(120))); // next 2 hours

        // Generate additional metrics map with random data
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("heartRate", random.nextInt(100) + 60); // 60-159 bpm
        metrics.put("steps", random.nextInt(5000) + 1000); // 1000-5999 steps
        dto.setAdditionalMetrics(metrics);

        return dto;
    }
}
