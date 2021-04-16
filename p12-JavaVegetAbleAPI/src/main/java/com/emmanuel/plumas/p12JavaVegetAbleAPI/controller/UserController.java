package com.emmanuel.plumas.p12JavaVegetAbleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/users")
	public List<UserEntity> getAllUsers(){
		List<UserEntity> userEntities=userService.getAllUsers();
		return userEntities;
	}

}
