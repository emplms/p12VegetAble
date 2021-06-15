package com.emmanuel.plumas.p12JavaVegetAbleWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies.ApiProxy;

@Service
public class ProvisionService {
	
	
	@Autowired
	private ApiProxy apiProxy;
	
	public List<ProvisionEntity> getAllProvisions(){
		List<ProvisionEntity> provisionEntities=apiProxy.getAllProvisions();
		return provisionEntities;
	}

	public List<ProvisionEntity> getProvisionsByUserIdentifiant(String userIdentifiant){
		return apiProxy.getProvisionsByUserIdentifiant(userIdentifiant);
	}

	public void createProvisionEntity(ProvisionEntity provisionEntity) {
		apiProxy.createProvision(provisionEntity);
		
	}
}
