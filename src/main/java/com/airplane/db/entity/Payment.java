package com.airplane.db.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="card_type")
	String cardType;
	
	@Column(name="card_number")
	String cardNumber;
	
	@Column(name="expiration_date")
	LocalDate expDate;
	
	@Column(name="name")
	String name;

	
	
	public Payment() {
		super();
	}

	public Payment(int id, String cardType, String cardNumber, LocalDate expDate, String name) {
		super();
		this.id = id;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.name = name;
	}

	public Payment(String cardType, String cardNumber, LocalDate expDate, String name) {
		super();
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", cardType=" + cardType + ", cardNumber=" + cardNumber + ", expDate=" + expDate
				+ ", name=" + name + "]";
	}
	
}