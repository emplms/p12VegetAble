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
	
	//TODO Ajouter le traitement des créations incorrectes ou impossibles
	// Identifiant déjà existant
	// Identifiant vide
	public void createUserEntity(UserEntity userEntity) {
		//Cryptage du mot de passe qui sera sauvegardé en base
		userEntity.setUserPassword(BCrypt.hashpw(userEntity.getUserPassword(),BCrypt.gensalt()));
		apiProxy.setUserEntity(userEntity);
	}
}
