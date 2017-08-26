package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO {
	

	

		public void save(Cart cart);
	    
			public Cart getId(int id);
			
			public void update(Cart cart);
			
			public void deleteById(Cart id);
			
			public List<Cart> getAll();
			
			public Cart findById(int id);
			
			public List<Cart> checkExistance(int productid);



}
