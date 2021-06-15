package com.emmanuel.plumas.p12JavaVegetAbleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories.IRequestRepository;

@Service
public class RequestService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private IRequestRepository requestRepository;
	
	public List<RequestEntity> getRequestsByUserIdentifiant(String userIdentifiant){
		UserEntity userEntity=userService.getUserEntityByUserIdentifiant(userIdentifiant);
		return requestRepository.findByUserEntity(userEntity);
	}
	
}
