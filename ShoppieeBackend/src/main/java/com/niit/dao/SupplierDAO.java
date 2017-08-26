package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.Supplier;

public interface SupplierDAO {
	
	List<Supplier> getAllSupplier();
	
	Supplier getSupplierDetail(int id);
	
	void updateSupplierDetail(Supplier obj);
	
	void addSupplier(Supplier obj);
	
	void deleteProduct(Supplier entity);

	public List<Supplier> getAllCategories();

}
