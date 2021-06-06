package com.emmanuel.plumas.p12JavaVegetAbleAPI.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="provision")
public class ProvisionEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long provisionId;
	private String provisionName;
	private String provisionDescription;
	private Date provisionAvailibilityDate;
	private String provisionStatus;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name="provision_category_id")
	private ProvisionCategoryEntity provisionCategoryEntity;

	public ProvisionEntity() {
		super();
	}

	

	public ProvisionEntity(Long provisionId, String provisionName, String provisionDescription,
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
