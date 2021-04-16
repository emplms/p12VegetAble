package com.emmanuel.plumas.p12JavaVegetAbleWEB.model;

public class AdressEntity {

	private Long adressId;
	private String adressTown;
	private int adressZipCode;
	private int adressPhoneNumber;
	private String adressEmail;
	
	public AdressEntity(Long adressId, String adressTown, int adressZipCode, int adressPhoneNumber,
			String adressEmail) {
		super();
		this.adressId = adressId;
		this.adressTown = adressTown;
		this.adressZipCode = adressZipCode;
		this.adressPhoneNumber = adressPhoneNumber;
		this.adressEmail = adressEmail;
	}

	public AdressEntity() {
		super();
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

	@Override
	public String toString() {
		return "AdressEntity [adressId=" + adressId + ", adressTown=" + adressTown + ", adressZipCode=" + adressZipCode
				+ ", adressPhoneNumber=" + adressPhoneNumber + ", adressEmail=" + adressEmail + "]";
	}
	
	
}
