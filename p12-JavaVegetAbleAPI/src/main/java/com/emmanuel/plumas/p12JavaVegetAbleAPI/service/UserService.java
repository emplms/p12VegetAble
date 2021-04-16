package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;
	
	public List<UserEntity> getAllUsers(){
		
		List<UserEntity> userEntities=(List<UserEntity>) userRepository.findAll();
		return userEntities;
	}
	
}
