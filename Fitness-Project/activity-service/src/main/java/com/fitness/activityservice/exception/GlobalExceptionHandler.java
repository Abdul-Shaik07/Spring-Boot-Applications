package com.fitness.activityservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ActivityIdNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> activityIdNotFoundException(ActivityIdNotFoundException activityIdNotFoundException) {
        ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(activityIdNotFoundException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ActivitiesNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> activitiesNotFoundException(ActivitiesNotFoundException activitiesNotFoundException) {
        ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(activitiesNotFoundException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> userIdNotFoundException(UserIdNotFoundException userIdNotFoundException) {
        ErrorResponseMessage errorResponseMessage = new ErrorResponseMessage(userIdNotFoundException.getMessage(), "NOT_FOUND");
        return new ResponseEntity<>(errorResponseMessage, HttpStatus.NOT_FOUND);
    }
}
