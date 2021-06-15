package com.emmanuel.plumas.p12JavaVegetAbleWEB.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class RequestEntity {

	private Long requestId;
	private String requestStatus;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private Date requestDate;
	private String requestComment;
	private UserEntity userEntity;
	private ProvisionEntity provisionEntity;
	
	public RequestEntity() {
		super();
	}

	public RequestEntity(Long requestId, String requestStatus, Date requestDate, String requestComment,
			UserEntity userEntity, ProvisionEntity provisionEntity) {
		super();
		this.requestId = requestId;
		this.requestStatus = requestStatus;
		this.requestDate = requestDate;
		this.requestComment = requestComment;
		this.userEntity = userEntity;
		this.provisionEntity = provisionEntity;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestComment() {
		return requestComment;
	}

	public void setRequestComment(String requestComment) {
		this.requestComment = requestComment;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public ProvisionEntity getProvisionEntity() {
		return provisionEntity;
	}

	public void setProvisionEntity(ProvisionEntity provisionEntity) {
		this.provisionEntity = provisionEntity;
	}

	
	
	
}
