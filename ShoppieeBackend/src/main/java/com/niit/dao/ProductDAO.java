package com.niit.dao;


import java.util.List;

import com.niit.model.Product;

public interface ProductDAO{
    	   
    	   List<Product> getAllProductDetails();
    	   
	       Product getProductDetail(int id);
	       
		   void updateCategoryDetails(Product obj);
		   
		   void addProduct(Product obj);
		   
		   public List<Product> getFilterProducts(int cid);
		   
		   public List<Product> getAllProducts();
		   
		   public void delete(Product obj);
		   
		   public Product findById(int id);

}
