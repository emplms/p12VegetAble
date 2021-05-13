package com.emmanuel.plumas.p12JavaVegetAbleBATCH.proxies;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.emmanuel.plumas.p12JavaVegetAbleBATCH.model.UserEntity;

@FeignClient(name="p12JavaVegetable-API", url="localhost:9001")
@Qualifier("ApiProxy")
public interface ApiProxy {
	
	@PostMapping(value="/user/update}")
	public void upDateUser(@RequestBody UserEntity userEntity);
	
	@GetMapping(value="/users")
	public List<UserEntity> getAllUsers();
}