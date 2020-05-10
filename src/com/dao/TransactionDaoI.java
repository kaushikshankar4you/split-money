package com.dao;

import javax.servlet.http.HttpServletRequest;

import com.entity.User;

public interface TransactionDaoI {

	
	public int setSplit(int id,int transaction_id,String[] phone,int p,String[] amt,int a);
	public int setBaseTransaction(int id,int initiator_id,int product_id);
	public int maxKey(String table_name, String id);
	public void setTransactionStatus(int id, String status);
	public void setUserConsent(int user_id, String consent);
}
