package com.emmanuel.plumas.p12JavaVegetAbleAPI.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionCategoryEntity;

@Repository
@Qualifier("IProvisionCategoryRepository")
public interface IProvisionCategoryRepository extends CrudRepository<ProvisionCategoryEntity, Long>{

}
