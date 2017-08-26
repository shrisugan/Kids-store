package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.SupplierDAO;
import com.niit.model.Cart;
import com.niit.model.Supplier;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	


	public List<Supplier> getAllSupplier() {
		Session sf =sessionFactory.openSession();
		sf.beginTransaction();		
		List<Supplier> list=sf.createCriteria(Supplier.class).list();
		System.out.println(list);
		sf.getTransaction().commit();
		return list;

	}

	public Supplier getSupplierDetail(int id) {
		Supplier s = sessionFactory.openSession().get(Supplier.class, id);
		return s;
	}

	public void updateSupplierDetail(Supplier obj) {
		// TODO Auto-generated method stub
		
	}

	public void addSupplier(Supplier obj) {
		Session i=sessionFactory.openSession();
		i.beginTransaction();
		i.save(obj);
		i.getTransaction().commit();
		i.close();
		// TODO Auto-generated method stub
		
	}

	public void deleteProduct(Supplier entity) {
		// TODO Auto-generated method stub
		
	}

	public List<Supplier> getAllCategories() {
		Session sf =sessionFactory.openSession();
		sf.beginTransaction();
		Query query = sf.createQuery("from Supplier");
		List<Supplier> slist=query.list();
		System.out.println(slist);
		sf.getTransaction().commit();
		return slist;
	}

}
