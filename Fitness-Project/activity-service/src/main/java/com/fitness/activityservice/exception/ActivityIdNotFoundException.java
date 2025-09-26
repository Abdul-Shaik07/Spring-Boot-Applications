package com.fitness.activityservice.exception;

public class ActivityIdNotFoundException extends RuntimeException {
    public ActivityIdNotFoundException(String message) {
        super(message);
    }
}
