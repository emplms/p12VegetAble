package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.Dto.ProvisionDtoEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.Dto.ProvisionTransformer;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories.IProvisionRepository;

@Service
public class ProvisionService {

	@Autowired
	private IProvisionRepository provisionRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProvisionTransformer provisionTransformer;
	
	public List<ProvisionDtoEntity> getAllProvisions(){
		List<ProvisionEntity> provisionEntities=(List<ProvisionEntity>) provisionRepository.findAll();
		return provisionTransformer.transformEntityListIntoDtoList(provisionEntities);
	}

	public List<ProvisionDtoEntity> getProvisionsByUserIdentifiant(String userIdentifiant) {
		UserEntity userEntity=userService.getUserEntityByUserIdentifiant(userIdentifiant);
		List<ProvisionEntity> provisionEntities=provisionRepository.findByUserEntity(userEntity);
		return provisionTransformer.transformEntityListIntoDtoList(provisionEntities);
	}
	
	public ProvisionEntity getProvisionEntityByProvisionId(Long provisionId) {
		ProvisionEntity provisionEntity= new ProvisionEntity();
		provisionEntity = provisionRepository.findByProvisionId(provisionId);
		return provisionEntity;
	}
	
	public void createProvisionEntity(ProvisionEntity provisionEntity) {		
		provisionRepository.save(provisionEntity);
	}
}
