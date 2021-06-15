package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionCategoryEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories.IProvisionCategoryRepository;

@Service
public class ProvisionCategoryService {

	@Autowired
	private IProvisionCategoryRepository provisionCategoryRepository;
	
	public List<ProvisionCategoryEntity> getAllProvisionCategoryEntities(){
		List<ProvisionCategoryEntity> provisionCategoryEntities = (List<ProvisionCategoryEntity>) provisionCategoryRepository.findAll();
		return provisionCategoryEntities;
	}
	
	
}
