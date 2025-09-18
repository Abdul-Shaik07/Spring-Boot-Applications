package com.fitness.userservice.service;

import com.fitness.userservice.dto.UsersDto;
import com.fitness.userservice.model.Users;
import com.fitness.userservice.repository.UsersRepository;
import com.fitness.userservice.response.UsersResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UsersService implements  IUsersService {

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsersResponse registerUsers(UsersDto usersDto) {

        if (usersRepository.existsByEmail(usersDto.getEmail())) {
            throw new RuntimeException("Email id already exists in db");
        }

        Users users = modelMapper.map(usersDto, Users.class);

        /*Users users = new Users();
        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());*/

        Users savedUser = usersRepository.save(users);
        return mapToResponse(savedUser);
    }

    @Override
    public UsersResponse fetchUserById(Integer userId) {
        Optional<Users> returningUsersId = usersRepository.findById(userId);
        if(returningUsersId.isEmpty()) {
            throw new RuntimeException("Users Id is not found in db to fetch");
        }
        Users users = returningUsersId.get();

        return mapToResponse(users);

    }

    @Override
    public Boolean fetchUserByIdValidate(Integer userId) {
        boolean existId = usersRepository.existsById(userId);
        if(existId) {
            return true;
        }
        return false;
    }

    private UsersResponse mapToResponse(Users users) {

        UsersResponse usersResponse = modelMapper.map(users, UsersResponse.class);

       /* UsersResponse usersResponse = new UsersResponse();
        usersResponse.setUserId(users.getUserId());
        usersResponse.setFirstName(users.getFirstName());
        usersResponse.setLastName(users.getLastName());
        ;usersResponse.setEmail(users.getEmail());
        usersResponse.setPassword(users.getPassword());
        usersResponse.setCreatedAt(users.getCreatedAt());
        usersResponse.setUpdatedAt(users.getUpdatedAt());*/
        return usersResponse;
    }
}








