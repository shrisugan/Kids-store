package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	
	
	public List<Category> getAllCategoryDetails() {
		
		Session sf =sessionFactory.openSession();
		sf.beginTransaction();
		Query query = sf.createQuery("from Category");
		List<Category> list=query.list();
		System.out.println(list);
		sf.getTransaction().commit();
		return list;
		
	}
		
	
		
	/*	Session session=sessionFactory.openSession();
		List<Category> category=null;
		session.beginTransaction();
		category=session.createQuery("from Category").list();
		session.getTransaction().commit();
		
		return category;*/
	

	public Category getCategoryDetail(int id) {
		
		Category c=(Category)sessionFactory.openSession().get(Category.class, id);
		// TODO Auto-generated method stub
		return c;
	}

	public void updateCategoryDetail(Category obj) {
		// TODO Auto-generated method stub
		
	}

	public void addCategory(Category obj)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(obj);
		s.getTransaction().commit();
		s.close();
		// TODO Auto-generated method stub
		
	}

	public void deleteProduct(Category entity) {
		// TODO Auto-generated method stub
		
	}
	

}
