package com.emmanuel.plumas.p12JavaVegetAbleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value="/user/{userIdentifiant}")
	public UserEntity getUserEntityByUserIdentifiant(@PathVariable String userIdentifiant) {
		UserEntity userEntity=userService.getUserEntityByUserIdentifiant(userIdentifiant);
		return userEntity;
	}
	
	@PostMapping(value="/user/update")
	public void upDateUser(@RequestBody UserEntity userEntity) {
		userEntity=userService.updateUser(userEntity);
	}
	
	@PostMapping(value="/user/createUserEntity")
	public void setUserEntity(@RequestBody UserEntity userEntity) {
		userService.saveUserEntity(userEntity);
	}
	
	
}
