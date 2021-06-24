package com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;

@Repository
@Qualifier("ProvisionRepository")
public interface IProvisionRepository extends CrudRepository <ProvisionEntity, Long>{

	List<ProvisionEntity> findByUserEntity(UserEntity userEntity);

	ProvisionEntity findByProvisionId(Long provisionId);
	
	List<ProvisionEntity> findByUserEntityUserId(Long userId);
}
