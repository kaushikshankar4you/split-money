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
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.ValidationDaoImpl;
import com.entity.Product;
import com.entity.Split;
import com.entity.User;

@Controller
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ValidationDaoImpl validdao;	

	public ValidationDaoImpl getValiddao() {
		return validdao;
	}

	public void setValiddao(ValidationDaoImpl validdao) {
		this.validdao = validdao;
	}
	
	
	@RequestMapping(value="productdetails.htm",method=RequestMethod.GET)
	public String productDetails(HttpServletRequest request, Model model)
	{
		List<Product> products = validdao.proDetails();
		model.addAttribute("products", products);
		/*Split s=validdao.notification((int)request.getSession().getAttribute("user_id"));
		if(s==null)
			model.addAttribute("notify","false");
		else{
			int transaction_id=s.getTransaction_id();
			int topay=s.getTopay();
			String user=validdao.getInitiator(transaction_id);
			String product=validdao.getProduct(transaction_id);
			model.addAttribute("notify","true");
		}	*/
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

}
