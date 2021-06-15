package com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;

@Repository
@Qualifier ("IRequestRepository")
public interface IRequestRepository extends CrudRepository<RequestEntity, Long>{

	List <RequestEntity> findByUserEntity(UserEntity userEntity);
}
