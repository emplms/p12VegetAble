package com.emmanuel.plumas.p12JavaVegetAbleWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies.ApiProxy;

@Service
public class RequestService {

	@Autowired
	private ApiProxy apiProxy;
	
	public List<RequestEntity> getSendedRequestByUserIdentifiant(String userIdentifiant){
		return apiProxy.getSendedRequestsByUserIdentifiant(userIdentifiant); 
	}
	
	public List<RequestEntity> getReceivedRequestByUserIdentifiant(String userIdentifiant){
		return apiProxy.getReceivedRequestByUserIdentifiant(userIdentifiant);
	}

	public void createRequest(RequestEntity requestEntity) {
		apiProxy.setRequestEntity(requestEntity);
		
	}
}
