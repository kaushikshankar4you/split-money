package com.entity;

public class Transaction {
	
	private int id;
	private int user_id;
	private int product_id;
	private int collected_money;
	
	public int getCollected_money() {
		return collected_money;
	}
	public void setCollected_money(int collected_money) {
		this.collected_money = collected_money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Transaction(int id, int user_id, int product_id, boolean status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
	}
	public Transaction() {
		super();
	}
	
	
	
		
}
