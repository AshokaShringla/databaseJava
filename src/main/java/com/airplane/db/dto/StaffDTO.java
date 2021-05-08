package com.airplane.db.dto;

import java.time.LocalDate;


public class StaffDTO {
	
	String username;
	
	String password;

	String fname;

	String lname;

	LocalDate dateBirth;

	String airline;

	public StaffDTO() {
		super();
	}

	public StaffDTO(String username, String password, String fname, String lname, LocalDate dateBirth, String airline) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.dateBirth = dateBirth;
		this.airline = airline;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "StaffDTO [username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", dateBirth=" + dateBirth + ", airline=" + airline + "]";
	}

	public StaffDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
