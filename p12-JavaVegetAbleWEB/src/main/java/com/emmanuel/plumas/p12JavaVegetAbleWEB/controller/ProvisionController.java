package com.emmanuel.plumas.p12JavaVegetAbleWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.ProvisionService;

@Controller
public class ProvisionController extends CommonController{

	@Autowired
	private ProvisionService provisionService;
	
	@GetMapping(value="/provisions")
	public String getProvisionsEntities(Model model) {
		List<ProvisionEntity> provisionEntities=provisionService.getAllProvisions();
		model.addAttribute("provisionEntities", provisionEntities);
		return "provisionpage";
	}
	
	@GetMapping(value="/provisionsByUserIdentifiant")
	public String getProvisionsByUserIdentifiant(Model model) {
		List<ProvisionEntity> provisionEntities=provisionService.getProvisionsByUserIdentifiant(getPrincipal());
		model.addAttribute("provisionEntities",provisionEntities);
		return "provisionsbyuseridentifiant";
	}
}
