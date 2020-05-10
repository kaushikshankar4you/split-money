package com.entity;

public class Transaction_Status {

	private int id;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Transaction_Status(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public Transaction_Status() {
		super();
	}
	
		
		
}
