package com.emmanuel.plumas.p12JavaVegetAbleWEB.model;

public class UserEntity {

	private Long userId;
	private String userIdentifiant;
	private String userPassword;
	private String userLastName;
	private String userFirstName;
	private AdressEntity adressEntity;
	
	public UserEntity(Long userId, String userIdentifiant, String userPassword, String userLastName,
			String userFirstName, AdressEntity adressEntity) {
		super();
		this.userId = userId;
		this.userIdentifiant = userIdentifiant;
		this.userPassword = userPassword;
		this.userLastName = userLastName;
		this.userFirstName = userFirstName;
		this.adressEntity = adressEntity;
	}

	public UserEntity() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserIdentifiant() {
		return userIdentifiant;
	}

	public void setUserIdentifiant(String userIdentifiant) {
		this.userIdentifiant = userIdentifiant;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public AdressEntity getAdressEntity() {
		return adressEntity;
	}

	public void setAdressEntity(AdressEntity adressEntity) {
		this.adressEntity = adressEntity;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userIdentifiant=" + userIdentifiant + ", userPassword="
				+ userPassword + ", userLastName=" + userLastName + ", userFirstName=" + userFirstName
				+ ", adressEntity=" + adressEntity + "]";
	}
	
	
	
}
