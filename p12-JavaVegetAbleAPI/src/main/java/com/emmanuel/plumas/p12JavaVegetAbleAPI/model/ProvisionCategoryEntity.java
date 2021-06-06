package com.emmanuel.plumas.p12JavaVegetAbleAPI.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="provisionCategory")
public class ProvisionCategoryEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
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

	public void setProvisionCategoryid(Long provisionCategoryId) {
		this.provisionCategoryId = provisionCategoryId;
	}

	public String getProvisionCategoryName() {
		return provisionCategoryName;
	}

	public void setProvisionCategoryName(String provisionCategoryName) {
		this.provisionCategoryName = provisionCategoryName;
	}

	
	
	
}
