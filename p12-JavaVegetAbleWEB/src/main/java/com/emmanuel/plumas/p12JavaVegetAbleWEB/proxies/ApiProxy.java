package com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
}
