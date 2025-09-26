package com.wipro.spring.security.service;

import java.util.List;

import com.wipro.spring.security.entity.UserEntity;

public interface IUserEntityService {
	
	UserEntity addUserEntity(UserEntity userEntity);
	
	List<UserEntity> findAllUserEntity();
	
	UserEntity findUserEntityById(long userId);
	
	String login(UserEntity userEntity);

}
