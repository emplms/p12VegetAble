package com.emmanuel.plumas.p12JavaVegetAbleBATCH.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleBATCH.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleBATCH.proxies.ApiProxy;

@Service
@Qualifier("UserPasswordCryptation")
public class UserPasswordCryptation {

	@Autowired
	@Qualifier("ApiProxy")
	private ApiProxy apiProxy;
	
	public void execute() {
		List<UserEntity> userEntities=apiProxy.getAllUsers();
		
		for(UserEntity userEntity:userEntities) {
			userEntity.setUserPassword(BCrypt.hashpw(userEntity.getUserPassword(),BCrypt.gensalt()));
			apiProxy.upDateUser(userEntity);
			System.out.println("le mot de passe de "+userEntity.getUserIdentifiant()+" a été crypté en base");
		}
	}
}
