package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories.IRequestRepository;

@Service
public class RequestService {
	
	@Autowired
	private IRequestRepository requestRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProvisionService provisionService;
	
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

	public void createRequestEntity(RequestEntity requestEntity) {
		requestEntity.setProvisionEntity(provisionService.getProvisionEntityByProvisionId(requestEntity.getProvisionEntity().getProvisionId()));
		requestEntity.setUserEntity(userService.getUserById(requestEntity.getUserEntity().getUserId()));
		//Status par défaut à la création de la demande
		requestEntity.setRequestStatus("En attente d'acceptation");
		Date date = new Date();
		requestEntity.setRequestDate(date);
		requestRepository.save(requestEntity);		
	}
	
}
