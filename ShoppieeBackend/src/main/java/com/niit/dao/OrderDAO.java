package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.Order;

public interface OrderDAO {
	
	
			List<Order> getAllOrder();
			
			Cart getOrderDetail(String id);
			
			void updateOrderDetail(Order obj);
			
			void addOrder(Order obj);
			
			void deleteProduct(Order entity);

}
