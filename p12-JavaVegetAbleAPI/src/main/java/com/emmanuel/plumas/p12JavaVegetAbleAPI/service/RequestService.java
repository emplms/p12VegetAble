package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories.IRequestRepository;

@Service
public class RequestService {
	
	@Autowired
	private IRequestRepository requestRepository;
	
	public List<RequestEntity> getSendedRequestsByUserIdentifiant(String userIdentifiant){
		return requestRepository.findByUserEntityUserIdentifiant(userIdentifiant);
	}
	
	public List<RequestEntity> getReceivedRequestByUserIdentifiant(String userIdentifiant){
		List<RequestEntity> requestEntities = (List<RequestEntity>) requestRepository.findAll();
		
		List<RequestEntity> receivedRequestEntities=new ArrayList<RequestEntity>();
		for(RequestEntity requestEntity : requestEntities) {
			if(requestEntity.getProvisionEntity().getUserEntity().getUserIdentifiant().equals(userIdentifiant)) {
				receivedRequestEntities.add(requestEntity);
			}
		}
		return receivedRequestEntities;
	}
	
}
