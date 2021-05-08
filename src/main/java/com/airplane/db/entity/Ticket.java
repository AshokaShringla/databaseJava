package com.airplane.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Entity
@Table(name="ticket")
public class Ticket {
		
		@Id
		@Column(name="ID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		int id;
		
		@Column(name="customer_email")
		String cEmail;	
		
		@Column(name="airline")
		String airline;
		
		@Column(name="flight_ID")
		int fId;
		
		@Column(name="sold_price")
		int sPrice;
		
		@Column(name="payment_ID")
		int pId;
		
		@Column(name="purchase_date_time")
		String pTime;
		
		@Column(name="booking_agent_ID")
		Integer baID;

		public Ticket() {
		}

		public Ticket(int id, String cEmail, String airline, int fId, int sPrice, int pId, String pTime, Integer baID) {
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
			return "Ticket [id=" + id + ", cEmail=" + cEmail + ", airline=" + airline + ", fId=" + fId + ", sPrice="
					+ sPrice + ", pId=" + pId + ", pTime=" + pTime + ", baID=" + baID + "]";
		}
		
}
