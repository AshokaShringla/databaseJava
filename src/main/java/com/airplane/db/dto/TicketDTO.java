package com.airplane.db.dto;

public class TicketDTO {
	
	int id;

	String cEmail;	

	String airline;

	int fId;

	int sPrice;

	int pId;

	String pTime;

	Integer baID;

	public TicketDTO() {
	}

	public TicketDTO(int id, String cEmail, String airline, int fId, int sPrice, int pId, String pTime, Integer baID) {
		super();
		this.id = id;
		this.cEmail = cEmail;
		this.airline = airline;
		this.fId = fId;
		this.sPrice = sPrice;
		this.pId = pId;
		this.pTime = pTime;
		this.baID = baID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	public Integer getBaID() {
		return baID;
	}

	public void setBaID(Integer baID) {
		this.baID = baID;
	}

	@Override
	public String toString() {
		return "TicketDTO [id=" + id + ", cEmail=" + cEmail + ", airline=" + airline + ", fId=" + fId + ", sPrice="
				+ sPrice + ", pId=" + pId + ", pTime=" + pTime + ", baID=" + baID + "]";
	}
	
}
