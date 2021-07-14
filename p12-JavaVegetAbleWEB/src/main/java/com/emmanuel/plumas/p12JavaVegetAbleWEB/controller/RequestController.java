package com.emmanuel.plumas.p12JavaVegetAbleWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.RequestService;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.service.UserService;

@Controller
public class RequestController extends CommonController {

	@Autowired
	private RequestService requestService;

	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/requestSendedByUserIdentifiant")
	public String getSendedRequestByUserIdentifiant(Model model) {
		List<RequestEntity> requestEntities = requestService.getSendedRequestByUserIdentifiant(getUserNamePrincipal());
		model.addAttribute("requestEntities", requestEntities);
		model.addAttribute("principal", getUserNamePrincipal());
		return "requestsbyuseridentifiant";
	}

	@GetMapping(value = "/requestReceivedByUserIdentifiant")
	public String getReceivedRequestByUserIdentifiant(Model model) {
		List<RequestEntity> requestEntities = requestService
				.getReceivedRequestByUserIdentifiant(getUserNamePrincipal());
		model.addAttribute("requestEntities", requestEntities);
		model.addAttribute("principal", getUserNamePrincipal());
		return "receivedrequestsbyuseridentifiant";
	}

	@GetMapping(value = "/requestCreation/{provisionId}")
	public String getRequestCreation(Model model, @PathVariable Long provisionId) {
		RequestEntity requestEntity = new RequestEntity();
		Long userId=userService.getUserEntityByUserIdentifiant(getUserNamePrincipal()).getUserId();
		UserEntity userEntity=new UserEntity();
		userEntity.setUserId(userId);
		requestEntity.setUserEntity(userEntity);
		
		ProvisionEntity provisionEntity=new ProvisionEntity();
		provisionEntity.setProvisionId(provisionId);
		requestEntity.setProvisionEntity(provisionEntity);
		model.addAttribute("requestForm",requestEntity);
		model.addAttribute("principal", getUserNamePrincipal());
		return "requestform";
	}
	
	@PostMapping(value = "/requestCreation")
	public String getRequestCreation(@ModelAttribute("requestForm") RequestEntity requestEntity) {
		requestService.createRequest(requestEntity);
		return "redirect:/requestSendedByUserIdentifiant";

	}
	
	@GetMapping(value="/request/acceptRequestReceivedByUserIdentifiant/{requestId}")
	public String getRequestAcceptation(@PathVariable Long requestId) {
		requestService.acceptRequest(requestId);
		return"redirect:/requestReceivedByUserIdentifiant";
	}
	
	@GetMapping(value="/request/refuseRequestReceivedByUserIdentifiant/{requestId}")
	public String getRequestRefusal(@PathVariable Long requestId) {
		requestService.refuseRequest(requestId);
		return"redirect:/requestReceivedByUserIdentifiant";
	}
	
	@GetMapping(value="/request/deliverResquest{requestId}")
	public String setRequestDeliveryStatus(@PathVariable Long requestId) {
		requestService.setRequestStatusOnDelivery(requestId);
		return "redirect:/requestSendedByUserIdentifiant";
	}
	
}
