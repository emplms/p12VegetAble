package com.emmanuel.plumas.p12JavaVegetAbleWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionCategoryEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies.ApiProxy;

@Service
public class ProvisionCategoryService {

	@Autowired
	private ApiProxy apiProxy;
	
	public List<ProvisionCategoryEntity>  getAllProvisionCategories(){
		List<ProvisionCategoryEntity> provisionCategoryEntities=apiProxy.getAllProvisionCategories();
		return provisionCategoryEntities;
	}
	
}
