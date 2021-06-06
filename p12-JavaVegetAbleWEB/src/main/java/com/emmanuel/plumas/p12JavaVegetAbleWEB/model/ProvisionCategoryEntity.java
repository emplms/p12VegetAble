package com.emmanuel.plumas.p12JavaVegetAbleWEB.model;

public class ProvisionCategoryEntity {

	private Long provisionCategoryId;
	private String provisionCategoryName;
	
	public ProvisionCategoryEntity() {
		super();
	}

	public ProvisionCategoryEntity(Long provisionCategoryId, String provisionCategoryName) {
		super();
		this.provisionCategoryId = provisionCategoryId;
		this.provisionCategoryName = provisionCategoryName;
	}

	public Long getProvisionCategoryId() {
		return provisionCategoryId;
	}

	public void setProvisionCategoryId(Long provisionCategoryId) {
		this.provisionCategoryId = provisionCategoryId;
	}

	public String getProvisionCategoryName() {
		return provisionCategoryName;
	}

	public void setProvisionCategoryName(String provisionCategoryName) {
		this.provisionCategoryName = provisionCategoryName;
	}	
	
}
