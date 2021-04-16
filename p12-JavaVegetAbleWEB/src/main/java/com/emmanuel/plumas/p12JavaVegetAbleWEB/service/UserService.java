package com.emmanuel.plumas.p12JavaVegetAbleWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies.ApiProxy;

@Service
public class UserService {

	@Autowired
	private ApiProxy apiProxy;
	
	public List<UserEntity> getAllUsers(){
		List<UserEntity> userEntities=apiProxy.getAllUsers();
		return userEntities;
	}
}
