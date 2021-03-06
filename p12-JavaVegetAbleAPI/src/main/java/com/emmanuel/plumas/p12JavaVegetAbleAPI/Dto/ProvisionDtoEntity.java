package com.emmanuel.plumas.p12JavaVegetAbleAPI.Dto;

import java.util.Date;

import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.ProvisionCategoryEntity;
import com.emmanuel.plumas.p12JavaVegetAbleAPI.model.UserEntity;

public class ProvisionDtoEntity {

	private Long provisionId;
	private String provisionName;
	private String provisionDescription;
	private Date provisionAvailibilityDate;
	private String provisionStatus;
	private UserEntity userEntity;
	private ProvisionCategoryEntity provisionCategoryEntity;
	
	public ProvisionDtoEntity() {
		super();
	}
	
	public ProvisionDtoEntity(Long provisionId, String provisionName, String provisionDescription,
			Date provisionAvailibilityDate, String provisionStatus, UserEntity userEntity,
			ProvisionCategoryEntity provisionCategoryEntity) {
		super();
		this.provisionId = provisionId;
		this.provisionName = provisionName;
		this.provisionDescription = provisionDescription;
		this.provisionAvailibilityDate = provisionAvailibilityDate;
		this.provisionStatus = provisionStatus;
		this.userEntity = userEntity;
		this.provisionCategoryEntity = provisionCategoryEntity;
	}



	public Long getProvisionId() {
		return provisionId;
	}
	public void setProvisionId(Long provisionId) {
		this.provisionId = provisionId;
	}
	public String getProvisionName() {
		return provisionName;
	}
	public void setProvisionName(String provisionName) {
		this.provisionName = provisionName;
	}
	public String getProvisionDescription() {
		return provisionDescription;
	}
	public void setProvisionDescription(String provisionDescription) {
		this.provisionDescription = provisionDescription;
	}
	public Date getProvisionAvailibilityDate() {
		return provisionAvailibilityDate;
	}
	public void setProvisionAvailibilityDate(Date provisionAvailibilityDate) {
		this.provisionAvailibilityDate = provisionAvailibilityDate;
	}
	public String getProvisionStatus() {
		return provisionStatus;
	}
	public void setProvisionStatus(String provisionStatus) {
		this.provisionStatus = provisionStatus;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public ProvisionCategoryEntity getProvisionCategoryEntity() {
		return provisionCategoryEntity;
	}
	public void setProvisionCategoryEntity(ProvisionCategoryEntity provisionCategoryEntity) {
		this.provisionCategoryEntity = provisionCategoryEntity;
	}
	
	
	
}
