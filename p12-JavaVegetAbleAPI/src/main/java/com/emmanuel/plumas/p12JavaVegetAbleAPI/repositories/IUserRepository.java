package com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;


@Repository
@Qualifier("IUserRepository")
public interface IUserRepository extends CrudRepository<UserEntity,Long>{
	
	UserEntity findByUserIdentifiant(String userIdentifiant);

	UserEntity findByUserId(Long id);
}
