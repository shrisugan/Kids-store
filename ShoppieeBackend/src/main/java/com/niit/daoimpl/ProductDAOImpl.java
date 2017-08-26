package com.niit.daoimpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")

	public List<Product> getAllProductDetails() {
		Session session=sessionFactory.openSession();
		List<Product> product=null;
		session.beginTransaction();
		product=session.createCriteria(Product.class).list();
		session.getTransaction().commit();
		
		return product;
	}

	public Product getProductDetail(int id) {
		Product p=(Product)sessionFactory.openSession().get(Product.class, id);

		// TODO Auto-generated method stub
		return null;
	}

	public void updateProductDetails(Product obj) {
		// TODO Auto-generated method stub
		
	}

	public void addProduct(Product obj) 
	{
		System.out.println("Product Implementation");
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(obj);
		s.getTransaction().commit();
		s.close();
		
	}

	public void updateCategoryDetails(Product obj) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(obj);
		s.getTransaction().commit();
		s.close();
		
	}

	public List<Product> getAllProducts() {
		Session sf = sessionFactory.openSession();
		sf.beginTransaction();
		Query query = sf.createQuery("from Product");
		List<Product> slist=query.list();
		System.out.println(slist);
		sf.getTransaction().commit();
		return slist;
	}

	public void delete(Product obj) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(obj);
		s.getTransaction().commit();
		s.close();
		
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.openSession().get(Product.class, id);
	}

	public List<Product> getFilterProducts(int cid) 	{
		Session s=sessionFactory.openSession();
		
		List<Product> results =s.createQuery("from Product where categoryId="+cid).list();
		s.close();
		// TODO Auto-generated method stub
		return results;
	}
	
	
}
