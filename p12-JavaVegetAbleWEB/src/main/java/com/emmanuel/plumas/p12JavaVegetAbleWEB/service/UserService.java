package com.emmanuel.plumas.p12JavaVegetAbleWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies.ApiProxy;

@Service
@Qualifier("UserService")
public class UserService {

	@Autowired
	private ApiProxy apiProxy;
	
	public List<UserEntity> getAllUsers(){
		List<UserEntity> userEntities=apiProxy.getAllUsers();
		return userEntities;
	}
	
	public UserEntity getUserEntityByUserIdentifiant(String userIdentifiant) {
		UserEntity userEntity=apiProxy.getUserEntityByUserIdentifiant(userIdentifiant);
		return userEntity;
	}
	
	
	public boolean createUserEntity(UserEntity userEntity) {
		//Cryptage du mot de passe qui sera sauvegardé en base
		userEntity.setUserPassword(BCrypt.hashpw(userEntity.getUserPassword(),BCrypt.gensalt()));
		Boolean userCreated=false;
		if(checkRegistration(userEntity)) {
			apiProxy.setUserEntity(userEntity);
			userCreated=true;
		}
		return userCreated;
	}
	
	//Verification des conditions de création de compte
	private boolean checkRegistration(UserEntity userEntity) {
		Boolean registrationIsChecked=false;
		if(checkIdentifiantNotExist(userEntity) && checkIdentifiantIsNotEmpty(userEntity)) {
			registrationIsChecked=true;
		}
		return registrationIsChecked;
	}
	
	//Identifiant déjà existant
	private boolean checkIdentifiantNotExist(UserEntity userEntity) {
		Boolean identifiantNotExist=true;
		List<UserEntity> userEntities=apiProxy.getAllUsers();
		for(UserEntity userEntityInBase :userEntities) {
			if(userEntityInBase.getUserIdentifiant().equals(userEntity.getUserIdentifiant())) {
				identifiantNotExist=false;
			}
		}
		return identifiantNotExist;
	}
	
	//Identifiant vide
	private boolean checkIdentifiantIsNotEmpty(UserEntity userEntity) {
		Boolean identifiantIsNotEmpty=false;
		if(!userEntity.getUserIdentifiant().isEmpty()) {
			identifiantIsNotEmpty=true;
		}
		return identifiantIsNotEmpty;
	}
}
