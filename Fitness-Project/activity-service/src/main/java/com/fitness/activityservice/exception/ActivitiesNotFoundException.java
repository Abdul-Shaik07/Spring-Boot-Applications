package com.fitness.activityservice.exception;

public class ActivitiesNotFoundException extends RuntimeException {
    public ActivitiesNotFoundException(String message) {
        super(message);
    }
}
