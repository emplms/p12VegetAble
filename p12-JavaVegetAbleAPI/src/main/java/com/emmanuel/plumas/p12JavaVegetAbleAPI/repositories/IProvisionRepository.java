package com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionEntity;

@Repository
@Qualifier("ProvisionRepository")
public interface IProvisionRepository extends CrudRepository <ProvisionEntity, Long>{

}
