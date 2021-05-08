package com.airplane.db.dto;

import java.time.LocalDate;

public class PaymentDTO {

	int id;

	String cardType;

	String cardNumber;

	LocalDate expDate;

	String name;

	public PaymentDTO() {
		super();
	}

	public PaymentDTO(int id, String cardType, String cardNumber, LocalDate expDate, String name) {
		super();
		this.id = id;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.name = name;
	}
	
	

	public PaymentDTO(String cardType, String cardNumber, LocalDate expDate, String name) {
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
		return "PaymentDTO [id=" + id + ", cardType=" + cardType + ", cardNumber=" + cardNumber + ", expDate=" + expDate
				+ ", name=" + name + "]";
	}
	
}
