package com.airplane.db.dto;

public class CustomerDTO {
	
	String customerEmail;

	String password;

	String name;

	int buildingNumber;

	String street;

	String city;

	String state;

	String phoneNumber;
	
	String passportNumber;

	String passportExpiration;

	String passportCountry;

	String dateBirth;
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(String customerEmail) {
		super();
		this.customerEmail = customerEmail;
	}


	public CustomerDTO(String customerEmail, String password) {
		super();
		this.customerEmail = customerEmail;
		this.password = password;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportExpiration() {
		return passportExpiration;
	}

	public void setPassportExpiration(String passportExpiration) {
		this.passportExpiration = passportExpiration;
	}

	public String getPassportCountry() {
		return passportCountry;
	}

	public void setPassportCountry(String passportCountry) {
		this.passportCountry = passportCountry;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
	
	

}
