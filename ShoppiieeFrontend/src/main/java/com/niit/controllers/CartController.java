package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

@Controller
public class CartController {
	
	    
	   @Autowired
		ProductDAO pdao;
		
		@Autowired
		CartDAO cdao;
		
		@RequestMapping("/ViewCart")
		public ModelAndView ViewCart(){
			
			ModelAndView mv=new ModelAndView("ViewCart");
			List<Cart> cartList=cdao.getAll();
			
			mv.addObject("cartlist", cartList);
			return mv;
		}
		
		@RequestMapping(value="/addCart", method=RequestMethod.POST)
		public ModelAndView addCart(HttpServletRequest request){
			int id=Integer.parseInt(request.getParameter("id"));
			int q=Integer.parseInt(request.getParameter("q"));

			Product p=pdao.findById(id);
			int price=p.getProdPrice();
			Cart c=new Cart();
			c.setPrices(price);
			c.setQuantity(q);
			//c.setC_status(0);
			c.setProductid(p);
			List<Cart> list=cdao.checkExistance(id);
			int count=list.size();
			System.out.println("No of times: "+count);
			if(count==0)
			{
				cdao.save(c);
			}
			else
			{
				Cart cart=cdao.findById(list.get(0).getCartid());
				int ex=cart.getQuantity();
				System.out.println("-----------Existance Count ="+ex+"\n current Count = "+q+"------------\n---Total =-"+(ex+q));
				int tot=ex+q;
				cart.setQuantity(tot);
				cdao.update(cart);
			}

			System.out.println(c);

			ModelAndView mv=new ModelAndView("ViewCart");
			List<Cart> cartList=cdao.getAll();

			mv.addObject("cartlist", cartList);
			return mv;

		}
		
		@RequestMapping("/cart_delete")
		public ModelAndView editCart(HttpServletRequest request)
		{
			int cid=Integer.valueOf(request.getParameter("id"));
			Cart c=cdao.findById(cid);
			cdao.deleteById(c);

			ModelAndView mv=new ModelAndView("ViewCart");
			List<Cart> cartList=cdao.getAll();

			mv.addObject("cartlist", cartList);
			return mv;
		}
		
		@RequestMapping("/UserRegistration")
		public ModelAndView customer(HttpServletRequest request)
		{
			int tot=Integer.valueOf(request.getParameter("tot"));
			
			ModelAndView mv=new ModelAndView("UserRegistration");
			mv.addObject("tot", tot);
			return mv;
		}
	   
	   @RequestMapping("/invoice")
		public ModelAndView invoice(HttpServletRequest request)
		{
			String name=request.getParameter("name");
			String add=request.getParameter("add");
			String phone=request.getParameter("contact_no");
			String email=request.getParameter("email");
			String tot=request.getParameter("tot");
			ModelAndView mv=new ModelAndView("invoice");
			mv.addObject("name", name);
			mv.addObject("add", add);
			mv.addObject("phone", phone);
			mv.addObject("email", email);
			mv.addObject("tot", tot);
			
		
			return mv;
		}

}