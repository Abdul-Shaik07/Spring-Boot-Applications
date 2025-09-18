package com.fitness.userservice.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsersResponse {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
