package com.fitness.activityservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/users/api/fetchUserByIdValidate/{userId}")
    Boolean fetchUserByIdValidate(@PathVariable("userId") Integer userId);

}
