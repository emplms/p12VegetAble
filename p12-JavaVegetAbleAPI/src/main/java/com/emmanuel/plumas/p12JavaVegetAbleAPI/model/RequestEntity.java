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
@Table(name="request")
public class RequestEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long requestId;
	private String requestStatus;
	private Date requestDate;
	private String requestComment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name="provision_id")
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
