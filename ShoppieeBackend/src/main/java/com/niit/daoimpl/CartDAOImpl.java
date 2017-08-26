package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;


@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void save(Cart cart1) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(cart1);
		s.getTransaction().commit();
		s.close();
		
	}

	public Cart getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Cart p) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(p);
		s.getTransaction().commit();
		s.close();
	}

	public void deleteById(Cart id) {
			Session session=sessionFactory.openSession();
			session.beginTransaction();

			Cart cart=(Cart)session.get(Cart.class,id);
			session.delete(cart);
			session.getTransaction().commit();
			
	}

	public List<Cart> getAll() {
		Session s=sessionFactory.openSession();
		List<Cart> clist=s.createCriteria(Cart.class).list();
		s.clear();
		return clist;
	}
	
	public Cart findById(int id) 
	{
		return (Cart)sessionFactory.openSession().get(Cart.class,id);
	}
	
	public List<Cart> checkExistance(int productid) 
	{
        Session s=sessionFactory.openSession();		
        List<Cart> results =s.createQuery("from Cart where prodId="+productid).list();		
		s.close();
		return results;
	}

	
}
