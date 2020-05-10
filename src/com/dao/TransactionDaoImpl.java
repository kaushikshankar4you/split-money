package com.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Split;
import com.entity.Transaction;
import com.entity.Transaction_Status;
import com.entity.User;
import com.entity.Wallet;

public class TransactionDaoImpl implements TransactionDaoI{

	
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate1) {
		this.hibernateTemplate = hibernateTemplate1;
	}


	@Override
	public int setSplit(int id,int transaction_id,String[] phone,int p,String[] amt,int a) {
		
		 int[] user_id=new int[p];int i;
         for(i=0;i<p;i++){
         	  String hql = "from User where phone=?";
         	  Object params = phone[i];
         	  List<User> user = hibernateTemplate.find(hql, params);
         	  System.out.println(user.get(0).getId());
         	  if(user.size()!=0)
         		  user_id[i]=user.get(0).getId();
         	  else
         		  return -1;
         }
 		
         int[] amount=new int[amt.length];
         for(i=0;i<a;i++)
         	amount[i]=Integer.parseInt(amt[i]);
         
         for(i=0;i<user_id.length;i++){
        	 Split s=new Split();
        	 s.setId(id);
        	 s.setTransaction_id(transaction_id);
        	 s.setUser_id(user_id[i]);
        	 s.setTopay(amount[i]);
        	 s.setConsent("");
        	 hibernateTemplate.save(s);
        	// updateWalletBalance(user_id[i],amount[i]);
         }
      
         return 0;
         
	}
	
	public void updateWalletBalance(int user_id,int amounttodeduct){
		String hql="from Wallet where id=?";
		Object params=user_id;
		List<Wallet> w=hibernateTemplate.find(hql,params);
		int newamount=w.get(0).getAmount()-amounttodeduct;
		hql="update Wallet set amount=? where user_id=?";
		Object[] params1={newamount,user_id};
		hibernateTemplate.update(params1);
	}
	
	@Override
	public int setBaseTransaction(int id,int initiator_id,int product_id) {
		
		Transaction t=new Transaction();
		t.setUser_id(initiator_id);
		t.setProduct_id(product_id);
		t.setId(id);
		hibernateTemplate.save(t);
		return t.getId();
	}
	
	@Override
	public void setTransactionStatus(int id, String status){
		Transaction_Status ts=new Transaction_Status();
		ts.setId(id);
		ts.setStatus(status);
		hibernateTemplate.save(ts);
	}
	
	@Override
	public int maxKey(String table_name, String id) {
		// TODO Auto-generated method stub
		String hql = "select max ("+id+") from "+table_name+"";
		System.out.println(hql);
		List<Integer> lst = hibernateTemplate.find(hql);
		System.out.println(lst);
		System.out.println(lst.get(0));
		if(lst == null||lst.get(0)==null) return 0;
		return lst.get(0);
	}

	@Override
	public void setUserConsent(int user_id, String consent) {
		// TODO Auto-generated method stub
		String hql = "update split set consent=? where Id=?";
		Object[] params = {consent,user_id};
		hibernateTemplate.update(params);
	}

	

	
}
