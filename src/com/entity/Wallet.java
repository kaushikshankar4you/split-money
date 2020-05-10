package com.entity;

public class Wallet{
	
	private int id;
	private int user_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Wallet(int id, int amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	public Wallet() {
		super();
	}
	
	
}