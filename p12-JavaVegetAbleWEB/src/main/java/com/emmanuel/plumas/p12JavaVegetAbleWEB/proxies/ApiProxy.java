package com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionCategoryEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.UserEntity;

@FeignClient(name="p12JavaVegetable-API", url="localhost:9001")
@Qualifier("ApiProxy")
public interface ApiProxy {

	@GetMapping(value="users")
	public List<UserEntity> getAllUsers();
	
	@GetMapping(value="/user/{userIdentifiant}")
	public UserEntity getUserEntityByUserIdentifiant(@PathVariable String userIdentifiant); 
	
	@PostMapping(value="/user/createUserEntity")
	public void setUserEntity(@RequestBody UserEntity userEntity);

	@GetMapping(value="/provisions")
	public List<ProvisionEntity> getAllProvisions();
	
	@GetMapping(value="/provision/{userIdentifiant}")
	public List<ProvisionEntity> getProvisionsByUserIdentifiant(@PathVariable String userIdentifiant);
	
	@PostMapping(value="provision/createProvision")
	public void createProvision(@RequestBody ProvisionEntity provisionEntity);
	
	@GetMapping(value="/provisionCategories")
	public List<ProvisionCategoryEntity> getAllProvisionCategories();
	
	@GetMapping(value="request/sended/{userIdentifiant}")
	public List<RequestEntity> getSendedRequestsByUserIdentifiant(@PathVariable String userIdentifiant);
	
	@GetMapping(value="request/received/{userIdentifiant}")
	public List<RequestEntity> getReceivedRequestByUserIdentifiant(@PathVariable String userIdentifiant);
	
	@PostMapping(value="request/createRequestEntity")
	public void setRequestEntity(@RequestBody RequestEntity requestEntity);

	@GetMapping(value="request/acceptRequest/{requestId}")
	public void acceptRequest(@PathVariable Long requestId);

	@GetMapping(value="request/refuseRequest/{requestId}")
	public void refuseRequest(@PathVariable Long requestId);
	
	@GetMapping(value="request/delivery/{requestId}")
	public void setRequestStatusOnDelivery(@PathVariable Long requestId);
	
}
