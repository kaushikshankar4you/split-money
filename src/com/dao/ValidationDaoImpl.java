package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Product;
import com.entity.Split;
import com.entity.User;
import com.entity.Wallet;

public class ValidationDaoImpl implements ValidationDaoI{

	
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate1) {
		this.hibernateTemplate = hibernateTemplate1;
	}


	@Override
	public User validateUser(String name, String pass) {
		
		String hql="from User where phone=? and password=?";
		Object[] params={name,pass};
		List<User> lst=hibernateTemplate.find(hql,params);
		if(lst.size()!=0)
			return lst.get(0);
		return null;
	}
	
	@Override
    public List<Product> proDetails()
    {
        String hql="from Product";
        List<Product> products=hibernateTemplate.find(hql);
        return products;    
    }
	

   @Override
   public Split notification(int user_id){
		   String hql = "from Split where user_id=? and consent=?";
	        Object[] params = { user_id,"" };
	        List<Split> s = hibernateTemplate.find(hql, params);
	        if(s.size()!=0)
	        	return s.get(0);  
	        return null;
   }
	
   @Override
   public String getInitiator(int transaction_id){
       String hql="select t.user_id from Transaction t where id=?";
       Object[] params1 = { transaction_id };
       List<Integer> uid=hibernateTemplate.find(hql,params1);
       hql="select ts.status from Transaction_Status ts where id=?";
       Object[] params2 = { transaction_id };
       List<String> status=hibernateTemplate.find(hql,params2);
       if(status.get(0).equals("ok")==false){
           hql="select u.name from User u where id=?";
           Object[] params3 = { uid.get(0) };
           List<String> uname=hibernateTemplate.find(hql,params3);
           if(uname.get(0)!=null)
               return uname.get(0);
       }
       return "";
   }
	
	@Override
	public int getWalletBalance(int user_id){
		String hql="from Wallet where id=?";
		Object params=user_id;
		List<Wallet> w=hibernateTemplate.find(hql,params);
		return w.get(0).getAmount();
	}
	
	@Override
	   public Product getProduct(int transaction_id){
	       String hql="select t.product_id from Transaction t where id=?";
	       Object[] params1 = { transaction_id };
	       List<Integer> pid=hibernateTemplate.find(hql,params1);
	       hql="from Product where id=?";
	       Object[] params3 = { pid.get(0) };
	       List<Product> product=hibernateTemplate.find(hql,params3);
	       if(product.size() != 0)
	            return product.get(0);
	       return null;
	   
	   }
	
	@Override
    public Product getProductDetails(int id) {
        // TODO Auto-generated method stub
        String hql = "from Product where id=?";
        Object params = id;
        List<Product> product = hibernateTemplate.find(hql, params);
        if(product.size() != 0)
            return product.get(0);
        return null;
    }
}
