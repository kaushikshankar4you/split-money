package com.entity;

public class User {

	private int id;
	private String phone;
	private String name;
	private String password;
	private int wallet_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	public User(int id, String phone, String name, String password, int wallet_id) {
		super();
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.password = password;
		this.wallet_id = wallet_id;
	}
	public User() {
		super();
	}
	
	
	
	
}
