package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.TransactionDaoImpl;
import com.dao.TransactionDaoI;
import com.entity.User;

@Controller
public class TransactionController {

        @Autowired
        private TransactionDaoImpl transdao;
        public TransactionDaoImpl getTransdao() {
            return transdao;
    }

    public void setTransdao(TransactionDaoImpl transdao) {
            this.transdao = transdao;
    }

    /*@RequestMapping(value="splitamount.htm",method=RequestMethod.GET)
    public String setSplitParameters(HttpServletRequest request,Model model){
            int initiator_id=(int) request.getSession().getAttribute("user_id");
            String[] phone=request.getParameterValues("phonenumber");
            String[] amt=request.getParameterValues("amount");
           
            int product_id=(int) (request.getSession().getAttribute("product_id"));
            boolean status=false;
            int transaction_id=transdao.setBaseTransaction(transdao.maxKey("Transaction", "id")+1,initiator_id,product_id,status);
            int state=transdao.setSplit(transdao.maxKey("Split", "id")+1,transaction_id,phone,amt);
            if(state==-1){
            	model.addAttribute("invaliduserlogin","The username and password do not match");
            	return "Split";
            }
            return "Products";
            	
    }*/
    

}
