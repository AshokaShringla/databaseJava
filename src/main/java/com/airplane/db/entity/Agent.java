package com.airplane.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking_agent")
public class Agent {
	
	@Id
	@Column(name="email")
	String email;
	
	@Column(name="pword")
	String password;
	
	@Column(name="ID")
	int id;

	public Agent() {
		super();
	}

	public Agent(String email, String password, int id) {
		super();
		this.email = email;
		this.password = password;
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Agent [email=" + email + ", password=" + password + ", id=" + id + "]";
	}

}
