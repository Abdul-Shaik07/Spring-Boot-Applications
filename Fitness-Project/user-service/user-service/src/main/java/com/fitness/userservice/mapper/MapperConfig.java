package com.fitness.userservice.mapper;

import com.fitness.userservice.dto.UsersDto;
import com.fitness.userservice.model.Users;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModelmapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(UsersDto.class, Users.class)
                .addMappings(mapper -> {
                    mapper.skip(Users::setUserId);
                    mapper.skip(Users::setCreatedAt);
                    mapper.skip(Users::setUpdatedAt);
                    mapper.skip(Users::setRoles);
                });
        return modelMapper;
    }
}
