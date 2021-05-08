package com.airplane.db.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airline_staff")
public class Staff {
	
	@Id
	@Column(name="username")
	String username;
	
	@Column(name="pword")
	String password;
	
	@Column(name="first_name")
	String fname;
	
	@Column(name="last_name")
	String lname;
	
	@Column(name="date_of_birth")
	LocalDate dateBirth;
	
	@Column(name="airline")
	String airline;

	public Staff() {
		super();
	}

	public Staff(String username, String password, String fname, String lname, LocalDate dateBirth, String airline) {
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
		return "Staff [username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", dateBirth=" + dateBirth + ", airline=" + airline + "]";
	}

}
