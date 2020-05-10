package com.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.ValidationDaoImpl;
import com.dao.TransactionDaoImpl;
import com.dao.ValidationDaoI;
import com.entity.Product;
import com.entity.Split;
import com.entity.User;

@Controller
public class LoginController {

	@Autowired
	private ValidationDaoImpl validdao;	

	public ValidationDaoImpl getValiddao() {
		return validdao;
	}

	public void setValiddao(ValidationDaoImpl validdao) {
		this.validdao = validdao;
	}
	
	@Autowired
	private TransactionDaoImpl transdao;	

	public TransactionDaoImpl getTransdao() {
		return transdao;
	}

	public void setTransdao(ValidationDaoImpl validdao) {
		this.validdao = validdao;
	}


	@RequestMapping(value="user.htm",method=RequestMethod.GET)
	public String index1(HttpServletRequest request,Model model){
		System.out.println(request.getSession().getAttribute("flag"));
		if(request.getSession(false).getAttribute("flag")==null)
			return "redirect:login.htm";
		return "Products";
	}
	
	
	@RequestMapping(value="indexhome.htm",method=RequestMethod.GET)
	public String index3(Model model){		
		return "redirect: reg.htm";
	}
	
	
	
	@RequestMapping(value="login.htm",method=RequestMethod.POST)
	public String setSession(HttpServletRequest request, HttpServletResponse response, Model model){
		
		String name=request.getParameter("uname");
		String password=request.getParameter("pwd");
	
		
			User user=validate(name,password);
			if(user!=null){
				HttpSession sess=request.getSession(true);
				if(sess.isNew()==false)
					sess.invalidate();
				sess = request.getSession(true);
				sess.setAttribute("user_id",user.getId());
				sess.setAttribute("phone",user.getPhone());
				sess.setAttribute("name",user.getName());
				sess.setAttribute("flag", 0);
				return "redirect: productdetails.htm";
			}
			model.addAttribute("invaliduserlogin","The username and password do not match");
			//int wallet_balance=validdao.getWalletBalance(user.getId());
			//model.addAttribute("wallet_balance",wallet_balance);
			return "Login";
		
	}
	

	public User validate(String name,String password){
		User user=validdao.validateUser(name, password);
		return user;
	}
	
	@RequestMapping(value="logout.htm",method=RequestMethod.GET)
	public String destroySession(HttpServletRequest request,Model model){
		
		int flag=0;
		
		HttpSession sess=request.getSession(false);
		
		
		if(sess!=null){
			flag=(int) sess.getAttribute("flag");
			sess.invalidate();
		}

		return "redirect: reg.htm";
			
	}
	
	
	@RequestMapping(value="productdetails.htm",method=RequestMethod.GET)
	   public String productDetails(HttpServletRequest request, Model model)
	   {
	       List<Product> products = validdao.proDetails();
	       model.addAttribute("products", products);
	       Split s=validdao.notification((int)request.getSession().getAttribute("user_id"));
	       if(s==null)
	           model.addAttribute("notify","false");
	       else{
	           int transaction_id=s.getTransaction_id();
	           int topay=s.getTopay();
	           String user=validdao.getInitiator(transaction_id);
	           Product product=validdao.getProduct(transaction_id);
	           model.addAttribute("initiator", user);
	           model.addAttribute("product", product);
	           model.addAttribute("topay", topay);
	           model.addAttribute("notify","true");
	       }    
	       return "Products";
	   }
	
	@RequestMapping(value="split.htm",method=RequestMethod.GET)
    public String split(HttpServletRequest request, Model model)
    {
        int id = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession(true);
        session.setAttribute("product_id", id);
        Product product = validdao.getProductDetails(id);
        model.addAttribute("product", product);
        return "Split";
    }
	
	
	
	@RequestMapping(value="splitamount.htm",method=RequestMethod.GET)
    public String setSplitParameters(HttpServletRequest request, Model model){
			
            int initiator_id=(int) request.getSession().getAttribute("user_id");
            int i=1,p=0,a=0;
            String[] phone=new String[10];String[] amount=new String[10];
            Enumeration paramNames = request.getParameterNames();
            	while(paramNames.hasMoreElements()) {
            		
            		String paramName = (String)paramNames.nextElement();
            		String paramValue = request.getParameter(paramName);
            	
            		if(i%2!=0)
            			phone[p++]=paramValue;
            		else
            			amount[a++]=paramValue;
            		i++;
            	}
           
            int product_id=(int) (request.getSession().getAttribute("product_id"));
            String status="waiting";
            int transaction_id=transdao.setBaseTransaction(transdao.maxKey("Transaction", "id")+1,initiator_id,product_id);
            int state=transdao.setSplit(transdao.maxKey("Split", "id")+1,transaction_id,phone,p,amount,a);
            if(state==-1){
            	model.addAttribute("incorrectphone","The phone number does not match");
            	System.out.println("Does not match");
            	return "Split";
            }
            transdao.setTransactionStatus(transdao.maxKey("Transaction_Status", "id")+1,status);
            return "Payment";
            	
    }
	
	@RequestMapping(value="consent.htm",method=RequestMethod.GET)
	public String handleConsent(HttpServletRequest request, Model model)
	{
		String consent = request.getParameter("consent");
		HttpSession sess = request.getSession(true);
		int user_id = Integer.parseInt(sess.getAttribute("user_id").toString());
		if(consent.equals("allow"))
		{
			//transdao.setUserConsent(user_id, "allow");
			
			return "Payment";
		}
		else
		{
			//transdao.setUserConsent(user_id, "deny");
			return "Products";
		}
	}
	
}
