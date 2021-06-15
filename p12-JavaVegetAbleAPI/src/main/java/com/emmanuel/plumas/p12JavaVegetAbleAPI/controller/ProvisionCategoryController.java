package com.emmanuel.plumas.p12JavaVegetAbleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionCategoryEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.service.ProvisionCategoryService;

@RestController
public class ProvisionCategoryController {

	@Autowired
	private ProvisionCategoryService provisionCategoryService;
	
	@GetMapping(value="/provisionCategories")
	public List<ProvisionCategoryEntity> getAllProvisionCategories() {
		return provisionCategoryService.getAllProvisionCategoryEntities();
	}
	
}
