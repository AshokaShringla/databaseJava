package com.airplane.db.dto;

import javax.persistence.Column;

public class AgentDTO {

	String email;

	String password;

	int id;

	public AgentDTO() {
		super();
	}

	public AgentDTO(String email, String password, int id) {
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
		return "AgentDTO [email=" + email + ", password=" + password + ", id=" + id + "]";
	}

}
