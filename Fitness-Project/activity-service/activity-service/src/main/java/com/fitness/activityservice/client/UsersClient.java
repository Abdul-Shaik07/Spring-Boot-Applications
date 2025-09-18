package com.fitness.activityservice.client;

import com.fitness.activityservice.response.UsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "USER-SERVICE")
public interface UsersClient {

    @GetMapping("/users/api/fetchUsersByIdValidate/{userId}")
    Boolean fetchUsersByIdValidate(@PathVariable("userId") Integer userId);

    @GetMapping("/users/api/fetchUsersById/{userId}")
    UsersResponse fetchUserById(@PathVariable("userId") Integer userId);



}
