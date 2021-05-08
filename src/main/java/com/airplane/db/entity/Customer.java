package com.airplane.db.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="email")
	String customerEmail;
	
	@Column(name="pword")
	String password;
	
	@Column(name="name")
	String name;
	
	@Column(name="building_number")
	int buildingNumber;
	
	@Column(name="street")
	String street;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	@Column(name="phone_number")
	String phoneNumber;
	
	@Column(name="passport_number")
	String passportNumber;
	
	@Column(name="passport_expiration")
	String passportExpiration;
	
	@Column(name="passport_country")
	String passportCountry;
	
	@Column(name="date_of_birth")
	String dateBirth;
	
	

	public Customer() {
		super();
	}

	public Customer(String customerEmail) {
		super();
		this.customerEmail = customerEmail;
	}

	public Customer(String customerEmail, String password) {
		super();
		this.customerEmail = customerEmail;
		this.password = password;
	}

	public Customer(String customerEmail, String password, String name, int buildingNumber, String street, String city,
			String state, String phoneNumber, String passportNumber, String passportExpiration, String passportCountry,
			String dateBirth) {
		super();
		this.customerEmail = customerEmail;
		this.password = password;
		this.name = name;
		this.buildingNumber = buildingNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.passportNumber = passportNumber;
		this.passportExpiration = passportExpiration;
		this.passportCountry = passportCountry;
		this.dateBirth = dateBirth;
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

	@Override
	public String toString() {
		return "Customer [customerEmail=" + customerEmail + ", password=" + password + ", name=" + name
				+ ", buildingNumber=" + buildingNumber + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", phoneNumber=" + phoneNumber + ", passportNumber=" + passportNumber + ", passportExpiration="
				+ passportExpiration + ", passportCountry=" + passportCountry + ", dateBirth=" + dateBirth + "]";
	}
	
	

}
