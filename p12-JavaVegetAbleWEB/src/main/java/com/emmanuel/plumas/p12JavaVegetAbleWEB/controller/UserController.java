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
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/users")
	public String getUserEntities(Model model) {
		List<UserEntity> userEntities=userService.getAllUsers();
		model.addAttribute("userEntities",userEntities);
		return "userspage";
	}
	
	@GetMapping(value="/user/createUser")
	public String createUserEntity(Model model) {
		UserEntity userEntity= new UserEntity();
		model.addAttribute("userForm", userEntity);
		return "userformpage";
	}
	
	//Gestion de la création réussie ou non
	//SI création réussie : aller sur une page de confirmation de création avec les données créées
	// Création de session??
	//SINON Message et rester sur la page de création de compte
	@PostMapping(value="/user/createUser")
	public String createUserEntity(Model model,@ModelAttribute("userForm") UserEntity userEntity) {
		boolean userCreated=false;
		userCreated=userService.createUserEntity(userEntity);
		if(userCreated) {
			model.addAttribute("userEntity", userEntity);
			return "confirmUserCreation";
		}else {
			String noUserCreationMessage="L'identifiant et/ou le mot de passe sont vides ou déjà utilisés. Veuillez recommencer l'inscription en cliquant sur le lien suivnat : ";
			model.addAttribute("noUserCreationMessage",noUserCreationMessage);
			return "noUserCreation";
		}
	}
}
