package com.entity;

import java.io.Serializable;

public class Split implements Serializable {
	
	private int id;
	private int transaction_id;
	private int user_id;
	private int topay;
	private String consent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTopay() {
		return topay;
	}
	public void setTopay(int topay) {
		this.topay = topay;
	}
	public String getConsent() {
		return consent;
	}
	public void setConsent(String consent) {
		this.consent = consent;
	}
	public Split(int id, int transaction_id, int user_id, int topay, String consent) {
		super();
		this.id = id;
		this.transaction_id = transaction_id;
		this.user_id = user_id;
		this.topay = topay;
		this.consent = consent;
	}
	public Split() {
		super();
	}
	
	
		
}
