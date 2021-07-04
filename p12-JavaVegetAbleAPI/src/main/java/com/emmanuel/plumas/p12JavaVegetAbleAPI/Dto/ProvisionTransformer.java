package com.emmanuel.plumas.p12JavaVegetAbleAPI.Dto;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.RequestEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.service.RequestService;

@Service
public class ProvisionTransformer {

	@Autowired
	private RequestService requestService;

	public ProvisionDtoEntity transformEntityIntoDto(ProvisionEntity provisionEntity) {
		ProvisionDtoEntity provisionDtoEntity = new ProvisionDtoEntity();
		provisionDtoEntity.setProvisionId(provisionEntity.getProvisionId());
		provisionDtoEntity.setProvisionName(provisionEntity.getProvisionName());
		provisionDtoEntity.setProvisionCategoryEntity(provisionEntity.getProvisionCategoryEntity());
		provisionDtoEntity.setProvisionDescription(provisionEntity.getProvisionDescription());
		provisionDtoEntity.setProvisionAvailibilityDate(provisionEntity.getProvisionAvailibilityDate());
		provisionDtoEntity.setUserEntity(provisionEntity.getUserEntity());
		provisionDtoEntity.setProvisionStatus(calculateProvisionDtoEntityStatus(provisionDtoEntity));
		return provisionDtoEntity;
	}
	
	
	public List<ProvisionDtoEntity> transformEntityListIntoDtoList(List<ProvisionEntity> provisionEntities){
		List<ProvisionDtoEntity> provisionDtoEntities = new ArrayList<>();
		for(ProvisionEntity provisionEntity:provisionEntities) {
			provisionDtoEntities.add(transformEntityIntoDto(provisionEntity));
		}
		return provisionDtoEntities;
	}
	

	private String calculateProvisionDtoEntityStatus(ProvisionDtoEntity provisionDtoEntity) {
		String provisionDtoEntityStatus = "Disponible";

		List<RequestEntity> requestEntities = requestService
				.getRequestsByProvisionId(provisionDtoEntity.getProvisionId());
		int nbEnAttenteDeReponse = 0;
		int nbEnAttenteDeLivraison = 0;
		int nbLivree = 0;

		if (!requestEntities.isEmpty()) {
			for (RequestEntity requestEntity : requestEntities) {
				if(requestEntity.getRequestStatus().equalsIgnoreCase("En attente de réponse")) {
					 nbEnAttenteDeReponse++;
				}else if(requestEntity.getRequestStatus().equalsIgnoreCase("En attente de livraison")){
					nbEnAttenteDeLivraison++;
				}else if(requestEntity.getRequestStatus().equalsIgnoreCase("Livrée")){
					nbLivree++;
				}
			}
		}

		if (nbEnAttenteDeReponse != 0) {
			provisionDtoEntityStatus = "En attente de réponse";
		} else if (nbEnAttenteDeLivraison != 0) {
			provisionDtoEntityStatus = "En attente de livraison";
		} else if (nbLivree != 0) {
			provisionDtoEntityStatus = "Livré";
		}

		return provisionDtoEntityStatus;
	}


	public ProvisionEntity transformDtoIntoEntity(ProvisionDtoEntity provisionDtoEntity) {
		ProvisionEntity provisionEntity = new ProvisionEntity();
		provisionEntity.setProvisionName(null);
		provisionEntity.setProvisionDescription(null);
		provisionEntity.setProvisionCategoryEntity(null);
		provisionEntity.getProvisionAvailibilityDate();
		provisionEntity.setUserEntity(null);
		return provisionEntity;
	}

}
