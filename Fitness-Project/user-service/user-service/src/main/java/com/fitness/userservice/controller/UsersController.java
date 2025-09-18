package com.fitness.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.userservice.dto.UsersDto;
import com.fitness.userservice.response.UsersResponse;
import com.fitness.userservice.service.IUsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/api")
public class UsersController {

    @Autowired
    private IUsersService iUsersService;

    @PostMapping("/registerUsers")
    public ResponseEntity<UsersResponse> registerUsers(@RequestBody @Valid UsersDto usersDto) {
        return ResponseEntity.ok(iUsersService.registerUsers(usersDto));
    }

    @GetMapping("/fetchUsersById/{userId}")
    public ResponseEntity<UsersResponse> fetchUserById(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(iUsersService.fetchUserById(userId));

    }

    @GetMapping("/fetchUsersByIdValidate/{userId}")
    public ResponseEntity<Boolean> fetchUsersByIdValidate(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(iUsersService.fetchUserByIdValidate(userId));
    }
}
