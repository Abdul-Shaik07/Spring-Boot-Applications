package com.fitness.userservice.service;

import com.fitness.userservice.dto.UsersDto;
import com.fitness.userservice.response.UsersResponse;


public interface IUsersService {
    UsersResponse registerUsers(UsersDto usersDto);
    UsersResponse fetchUserById(Integer userId);

    Boolean fetchUserByIdValidate(Integer userId);
}

