package com.emmanuel.plumas.p12JavaVegetAbleWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/users")
	public String getUserEntities(Model model) {
		List<UserEntity> userEntities=userService.getAllUsers();
		model.addAttribute("userEntities",userEntities);
		return "userspage";
	}
}
