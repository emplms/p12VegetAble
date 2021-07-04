package com.emmanuel.plumas.p12JavaVegetAbleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.Dto.ProvisionDtoEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.service.ProvisionService;

@RestController
public class ProvisionController {

	@Autowired
	private ProvisionService provisionService;
	
	@GetMapping(value="/provisions")
	public List<ProvisionDtoEntity> getAllProvisions(){
		return provisionService.getAllProvisions();
	}
	
	@GetMapping(value="/provision/{userIdentifiant}")
	public List<ProvisionDtoEntity> getProvisionsByUserIdentifiant(@PathVariable String userIdentifiant){
		return provisionService.getProvisionsByUserIdentifiant(userIdentifiant);
	}
	
	@PostMapping(value="provision/createProvision")
	public void createProvision(@RequestBody ProvisionEntity provisionEntity) {
		provisionService.createProvisionEntity(provisionEntity);
	}
}
