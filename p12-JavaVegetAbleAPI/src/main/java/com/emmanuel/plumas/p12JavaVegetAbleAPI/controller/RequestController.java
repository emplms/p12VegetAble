package com.emmanuel.plumas.p12JavaVegetAbleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.service.RequestService;


@RestController
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@GetMapping(value="request/{userIdentifiant}")
	public List<RequestEntity> getRequestsByUserIdentifiant(@PathVariable String userIdentifiant){
		return requestService.getRequestsByUserIdentifiant(userIdentifiant); 
	}
}
