package com.emmanuel.plumas.p12JavaVegetAbleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.service.ProvisionService;

@RestController
public class ProvisionController {

	@Autowired
	private ProvisionService provisionService;
	
	@GetMapping(value="/provisions")
	public List<ProvisionEntity> getAllProvisions(){
		return provisionService.getAllProvisions();
	}
	
	@GetMapping(value="/provision/{userIdentifiant}")
	public List<ProvisionEntity> getProvisionsByUserIdentifiant(@PathVariable String userIdentifiant){
		return provisionService.getProvisionsByUserIdentifiant(userIdentifiant);
	}
}
