package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.dao.CategoryDAO;
import com.niit.dao.SupplierDAO;



	@RestController
	public class ListRestController 
	{
		@Autowired
		private CategoryDAO category;
		@Autowired
		private SupplierDAO supplier;
		
		@RequestMapping(value="/categorys", method=RequestMethod.GET)
		public @ResponseBody String getAll(){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(category.getAllCategoryDetails());
	    
	        return json;
		}
		
		@RequestMapping(value="/suppliers", method=RequestMethod.GET)
		public @ResponseBody String getSave(){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(supplier.getAllSupplier());
	    
	        return json;
		}
		
	    


}
