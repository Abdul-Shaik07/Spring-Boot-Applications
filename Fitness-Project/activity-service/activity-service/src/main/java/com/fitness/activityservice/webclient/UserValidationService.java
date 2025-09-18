package com.fitness.activityservice.webclient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class UserValidationService {

    private final WebClient webClient;
    public boolean validateUser(Integer userId) {
        return webClient
                .get()
                .uri("/users/api/fetchUsersByIdValidate/{userId}", userId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
    }
