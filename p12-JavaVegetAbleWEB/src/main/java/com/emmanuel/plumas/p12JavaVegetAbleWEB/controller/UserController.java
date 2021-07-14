package com.emmanuel.plumas.p12JavaVegetAbleWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.UserService;


@Controller
public class UserController extends CommonController{

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/users")
	public String getUserEntities(Model model) {
		List<UserEntity> userEntities=userService.getAllUsers();
		model.addAttribute("userEntities",userEntities);
		model.addAttribute("principal", getUserNamePrincipal());
		return "userspage";
	}
	
	@GetMapping(value="/user/createUser")
	public String createUserEntity(Model model) {
		UserEntity userEntity= new UserEntity();
		model.addAttribute("userForm", userEntity);
		return "userformpage";
	}
	
	//Gestion de la création réussie ou non
	//SI création réussie : aller sur la page de connection
	//SINON Message et rester sur la page de création de compte
	@PostMapping(value="/user/createUser")
	public String createUserEntity(Model model,@ModelAttribute("userForm") UserEntity userEntity) {
		boolean userCreated=false;
		userCreated=userService.createUserEntity(userEntity);
		if(userCreated) {
			//model.addAttribute("userEntity", userEntity);
			return "redirect:/login";
		}else {
			String noUserCreationMessage="L'identifiant et/ou le mot de passe sont vides ou déjà utilisés. Veuillez recommencer l'inscription en cliquant sur le lien suivant : ";
			model.addAttribute("noUserCreationMessage",noUserCreationMessage);
			return "noUserCreation";
		}
	}

}
