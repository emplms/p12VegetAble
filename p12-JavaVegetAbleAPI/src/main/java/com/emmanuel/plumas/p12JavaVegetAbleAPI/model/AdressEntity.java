package com.emmanuel.plumas.p12JavaVegetAbleAPI.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adress")
public class AdressEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private Long adressId;
	private String adressTown;
	private int adressZipCode;
	private int adressPhoneNumber;
	private String adressEmail;
	
	
	public AdressEntity() {
		super();
	}


	public AdressEntity(Long adressId, String adressTown, int adressZipCode, int adressPhoneNumber,
			String adressEmail) {
		super();
		this.adressId = adressId;
		this.adressTown = adressTown;
		this.adressZipCode = adressZipCode;
		this.adressPhoneNumber = adressPhoneNumber;
		this.adressEmail = adressEmail;
	}


	public Long getAdressId() {
		return adressId;
	}


	public void setAdressId(Long adressId) {
		this.adressId = adressId;
	}


	public String getAdressTown() {
		return adressTown;
	}


	public void setAdressTown(String adressTown) {
		this.adressTown = adressTown;
	}


	public int getAdressZipCode() {
		return adressZipCode;
	}


	public void setAdressZipCode(int adressZipCode) {
		this.adressZipCode = adressZipCode;
	}


	public int getAdressPhoneNumber() {
		return adressPhoneNumber;
	}


	public void setAdressPhoneNumber(int adressPhoneNumber) {
		this.adressPhoneNumber = adressPhoneNumber;
	}


	public String getAdressEmail() {
		return adressEmail;
	}


	public void setAdressEmail(String adressEmail) {
		this.adressEmail = adressEmail;
	}
	
	
	
	
	
}
