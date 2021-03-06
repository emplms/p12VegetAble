package com.emmanuel.plumas.p12JavaVegetAbleWEB.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionCategoryEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.ProvisionCategoryService;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.ProvisionService;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.UserService;

@Controller
public class ProvisionController extends CommonController{

	@Autowired
	private ProvisionService provisionService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ProvisionCategoryService provisionCategoryService;
	
	@GetMapping(value="/provisions")
	public String getProvisionsEntities(Model model) {
		List<ProvisionEntity> provisionEntities=provisionService.getAllProvisions();
		List<ProvisionEntity> availableProvisionEntities=new ArrayList<>();
		if(!provisionEntities.isEmpty()) {
			for(ProvisionEntity provisionEntity : provisionEntities) {
				if(provisionEntity.getProvisionStatus().equals("Disponible")) {
					availableProvisionEntities.add(provisionEntity);
				}
			}
		}
		model.addAttribute("principal", getUserNamePrincipal());
		model.addAttribute("provisionEntities", availableProvisionEntities);
		return "provisionpage";
	}
	
	@GetMapping(value="/provisionsByUserIdentifiant")
	public String getProvisionsByUserIdentifiant(Model model) {
		List<ProvisionEntity> provisionEntities=provisionService.getProvisionsByUserIdentifiant(getUserNamePrincipal());
		model.addAttribute("provisionEntities",provisionEntities);
		model.addAttribute("principal", getUserNamePrincipal());
		return "provisionsbyuseridentifiant";
	}
	
	@GetMapping(value="/provision/createProvision")
	public String createProvision (Model model) {
		ProvisionEntity provisionEntity= new ProvisionEntity();
		List<ProvisionCategoryEntity> provisionCategoryEntities=provisionCategoryService.getAllProvisionCategories();
		model.addAttribute("categories",provisionCategoryEntities);
		model.addAttribute("provisionForm", provisionEntity);
		model.addAttribute("principal", getUserNamePrincipal());
		return "provisionFormPage";
	}
	
	@PostMapping(value="/provision/createProvision")
	public String createProvision(@ModelAttribute("provisionForm") ProvisionEntity provisionEntity) {
		provisionEntity.setUserEntity(userService.getUserEntityByUserIdentifiant(getUserNamePrincipal()));
		//Par d??faut le don est disponible ?? la cr??ation
		provisionEntity.setProvisionStatus("Disponible");		
		provisionService.createProvisionEntity(provisionEntity);
		return "redirect:/provisionsByUserIdentifiant";
	}
}
