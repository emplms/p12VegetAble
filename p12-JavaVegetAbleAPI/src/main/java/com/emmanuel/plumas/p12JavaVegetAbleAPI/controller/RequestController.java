package com.emmanuel.plumas.p12JavaVegetAbleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.service.RequestService;


@RestController
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@GetMapping(value="request/sended/{userIdentifiant}")
	public List<RequestEntity> getRequestsByUserIdentifiant(@PathVariable String userIdentifiant){
		return requestService.getSendedRequestsByUserIdentifiant(userIdentifiant); 
	}
	
	@GetMapping(value="request/received/{userIdentifiant}")
	public List<RequestEntity> getReceivedRequestByUserIdentifiant(@PathVariable String userIdentifiant){
		return requestService.getReceivedRequestByUserIdentifiant(userIdentifiant);
	}
	
	@PostMapping(value="request/createRequestEntity")
	public void setRequestEntity(@RequestBody RequestEntity requestEntity) {
		requestService.createRequestEntity(requestEntity);
	}
	
	@GetMapping(value="request/acceptRequest/{requestId}")
	public void acceptRequest(@PathVariable Long requestId) {
		requestService.acceptRequest(requestId);
	}
	
	@GetMapping(value="request/refuseRequest/{requestId}")
	public void refuseRequest(@PathVariable Long requestId) {
		requestService.refuseRequest(requestId);
	}
	
	@GetMapping(value="request/delivery/{requestId}")
	public void setRequestStatusOnDelivery(@PathVariable Long requestId) {
		requestService.setRequestStatusOnDelivery(requestId);
	}
}
