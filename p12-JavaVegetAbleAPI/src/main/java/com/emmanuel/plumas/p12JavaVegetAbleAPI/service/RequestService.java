package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.Dto.ProvisionDtoEntity;
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

	public List<RequestEntity> getSendedRequestsByUserIdentifiant(String userIdentifiant) {
		return requestRepository.findByUserEntityUserIdentifiant(userIdentifiant);
	}

	public List<RequestEntity> getReceivedRequestByUserIdentifiant(String userIdentifiant) {
		List<ProvisionDtoEntity> provisionDtoEntities = provisionService
				.getProvisionsByUserIdentifiant(userIdentifiant);
		List<RequestEntity> receivedRequestEntities = new ArrayList<RequestEntity>();

		for (ProvisionDtoEntity provisionDtoEntity : provisionDtoEntities) {
			List<RequestEntity> requestEntities = requestRepository
					.findByProvisionEntityProvisionId(provisionDtoEntity.getProvisionId());
			receivedRequestEntities.addAll(requestEntities);
		}
		return receivedRequestEntities;
	}

	public void createRequestEntity(RequestEntity requestEntity) {
		requestEntity.setProvisionEntity(
				provisionService.getProvisionEntityByProvisionId(requestEntity.getProvisionEntity().getProvisionId()));
		requestEntity.setUserEntity(userService.getUserById(requestEntity.getUserEntity().getUserId()));
		// Status par défaut à la création de la demande
		requestEntity.setRequestStatus("En attente de réponse");
		Date date = new Date();
		requestEntity.setRequestDate(date);
		requestRepository.save(requestEntity);
	}

	public void acceptRequest(Long requestId) {
		RequestEntity requestEntity = requestRepository.findByRequestId(requestId);
		requestEntity.setRequestStatus("En attente de livraison");
		requestRepository.save(requestEntity);

	}

	public void refuseRequest(Long requestId) {
		RequestEntity requestEntity = requestRepository.findByRequestId(requestId);		
		requestEntity.setRequestStatus("Refusée");
		requestRepository.save(requestEntity);
	}
	
	
	public List<RequestEntity> getRequestsByProvisionId(Long provisionId) {
		return requestRepository.findByProvisionEntityProvisionId(provisionId);
	}

	

}
