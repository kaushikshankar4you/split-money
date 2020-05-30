package com.dao;

import com.entity.Product;
import com.entity.Split;
import com.entity.User;

import java.util.List;

public interface ValidationDaoI {

	public Split notification(int user_id);
	public User validateUser(String name,String pass);
	public List<Product> proDetails();
	public String getInitiator(int transaction_id);
	public Product getProduct(int transaction_id);
	public Product getProductDetails(int id);
	public int getWalletBalance(int user_id);
}
