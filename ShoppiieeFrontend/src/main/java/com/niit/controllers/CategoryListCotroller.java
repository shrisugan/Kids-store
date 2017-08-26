package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

	@Controller
	public class CategoryListCotroller
	{
		@Autowired
		ProductDAO products;
		
		@Autowired
		CategoryDAO cdao;
	
		
		@RequestMapping(value ="admin/categoryList")
	    public ModelAndView add() {
	        List<Category> list=cdao.getAllCategoryDetails();
		 ModelAndView c1=new ModelAndView("categoryList");
		 c1.addObject("list",list);
			return c1;
	    }
		
			@RequestMapping(value ="admin/productlist")
		    public ModelAndView add1() {
				List<Product> list=products.getAllProductDetails();
		       ModelAndView c1=new ModelAndView("productlist");
			   /*c1.addObject("list", list);*/
			   c1.getModelMap().addAttribute("list",list);
				return c1;
		    }
			

}
