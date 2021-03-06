package com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;

@Repository
@Qualifier ("IRequestRepository")
public interface IRequestRepository extends CrudRepository<RequestEntity, Long>{

	List<RequestEntity> findByUserEntityUserIdentifiant(String userIdentifiant);
	
	List<RequestEntity>findByProvisionEntityProvisionId(Long provisionId);
	
	RequestEntity findByRequestId(Long requestId);
}
