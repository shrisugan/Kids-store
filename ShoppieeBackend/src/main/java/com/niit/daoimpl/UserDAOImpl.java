package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;


@Repository("userDao")
public class UserDAOImpl implements UserDAO{
	@Autowired
	   SessionFactory sessionFactory;
	 public List<User> getAllUserDetails() {
	       
	       Session sf =sessionFactory.openSession();
	       sf.beginTransaction();
	       Query query = sf.createQuery("from User");
	       List<User> list=query.list();
	       System.out.println(list);
	       sf.getTransaction().commit();
	       return list;
	       
	   }
	       
	   
	       
	   /*    Session session=sessionFactory.openSession();
	       List<Category> category=null;
	       session.beginTransaction();
	       category=session.createQuery("from Category").list();
	       session.getTransaction().commit();
	       
	       return category;*/
	   

	   public User getUserDetail(String id) {
	       
	   	User c=(User)sessionFactory.openSession().get(User.class, id);
	       // TODO Auto-generated method stub
	       return c;
	   }

	   public void updateUserDetail(User obj) {
	       // TODO Auto-generated method stub
	       
	   }

	   public void addUser(User obj)
	   {
	       Session s=sessionFactory.openSession();
	       s.beginTransaction();
	       s.save(obj);
	       s.getTransaction().commit();
	       s.close();
	       // TODO Auto-generated method stub
	       
	   }
		public void deleteUser(User entity) {
			// TODO Auto-generated method stub
			
		}

}
