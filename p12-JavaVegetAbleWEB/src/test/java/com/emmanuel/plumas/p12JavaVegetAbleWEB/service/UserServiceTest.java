package com.emmanuel.plumas.p12JavaVegetAbleWEB.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.model.UserEntity;
import com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies.ApiProxy;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	
	@Mock
	ApiProxy apiProxy;
	
	@Mock
	UserService userService;
	
	@BeforeEach
	void init() {
		userService=new UserService();
	}
	
	@Test
	void testCheckIdentifiantIsNotEmptyTrue() {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserIdentifiant("Ingrid");
		assertTrue(userService.checkIdentifiantIsNotEmpty(userEntity));
		
	}
	
	@Test
	void testCheckIdentifiantIsNotEmptyFalse() {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserIdentifiant("");
		assertTrue(!userService.checkIdentifiantIsNotEmpty(userEntity));

	}
	
	@Test
	void testCheckPasswordIsNotEmptyTrue() {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserPassword("jubJKDBVHO");
		assertTrue(userService.checkPasswordIsNotEmpty(userEntity));

	}

	@Test
	void testCheckPasswordIsNotEmptyFalse() {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserPassword("");
		assertTrue(!userService.checkPasswordIsNotEmpty(userEntity));

	}
	
	
	@Test
	void testCheckIdentifiantNotExistTrue() {
		userService.setApiProxy(apiProxy);
		
		UserEntity userEntity=new UserEntity();
		userEntity.setUserIdentifiant("Ingrid");
		
		List<UserEntity> userEntities1= new ArrayList<UserEntity>();
		UserEntity userEntity1=new UserEntity();
		userEntity1.setUserIdentifiant("Isabelle");
		userEntities1.add(userEntity1);
		
		UserEntity userEntity2=new UserEntity();
		userEntity2.setUserIdentifiant("Christophe");
		userEntities1.add(userEntity2);
		when(apiProxy.getAllUsers()).thenReturn(userEntities1);

		Boolean exist =userService.checkIdentifiantNotExist(userEntity);

		verify(apiProxy).getAllUsers();
		assertTrue(exist);
		
	}
	
	
	@Test
	void testCheckIdentifiantNotExistFalse() {
		userService.setApiProxy(apiProxy);
		
		UserEntity userEntity=new UserEntity();
		userEntity.setUserIdentifiant("Ingrid");
		
		List<UserEntity> userEntities2= new ArrayList<UserEntity>();
		UserEntity userEntity1=new UserEntity();
		userEntity1.setUserIdentifiant("Isabelle");
		userEntities2.add(userEntity1);
		
		UserEntity userEntity2=new UserEntity();
		userEntity2.setUserIdentifiant("Ingrid");
		userEntities2.add(userEntity2);
		when(apiProxy.getAllUsers()).thenReturn(userEntities2);
		
		Boolean exist =userService.checkIdentifiantNotExist(userEntity);
		
		verify(apiProxy).getAllUsers();
		assertTrue(!exist);
	}
	
	
	
	
}
