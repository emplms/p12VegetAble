package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories.IProvisionRepository;

@Service
public class ProvisionService {

	@Autowired
	private IProvisionRepository provisionRepository;
	
	public List<ProvisionEntity> getAllProvisions(){
		List<ProvisionEntity> provisionEntities=(List<ProvisionEntity>) provisionRepository.findAll();
		return provisionEntities;
	}
	
}
