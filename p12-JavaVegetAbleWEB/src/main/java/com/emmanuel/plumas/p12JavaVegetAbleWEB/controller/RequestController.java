package com.emmanuel.plumas.p12JavaVegetAbleWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.RequestService;

@Controller
public class RequestController extends CommonController {

	@Autowired
	private RequestService requestService;
	
	@GetMapping(value="/requestSendedByUserIdentifiant")
	public String getSendedRequestByUserIdentifiant(Model model){
		List <RequestEntity> requestEntities = requestService.getSendedRequestByUserIdentifiant(getUserNamePrincipal());
		model.addAttribute("requestEntities", requestEntities);
		return "requestsbyuseridentifiant";
		
	}
	
	@GetMapping(value="/requestReceivedByUserIdentifiant")
	public String getReceivedRequestByUserIdentifiant(Model model){
		List <RequestEntity> requestEntities = requestService.getReceivedRequestByUserIdentifiant(getUserNamePrincipal());
		model.addAttribute("requestEntities", requestEntities);
		return "receivedrequestsbyuseridentifiant";
		
	}
	
}
