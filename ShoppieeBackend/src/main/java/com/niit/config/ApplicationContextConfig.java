package com.niit.config;

	import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Order;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

	@Configuration
	@ComponentScan("com.niit")
	@EnableTransactionManagement
	public class ApplicationContextConfig 
	{
		   @Autowired
		    @Bean(name = "dataSource")
		    public DataSource getH2DataSource() {

		        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		            
		        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test5");

		        dataSource.setDriverClassName("org.h2.Driver");
	  
		        dataSource.setUsername("sa");
		        dataSource.setPassword("");
		        
		        
		        return dataSource;
		    }
		    
		   private Properties getHibernateProperties() {
		        Properties properties = new Properties();
		        properties.put("hibernate.show_sql", "true");
		        properties.put("hibernate.hbm2ddl.auto", "update");
		        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		        //properties.setProperty("hibernate.hbm2ddl.auto", "update");
		        properties.put("hibernate.format_sql", "true");
		        //properties.put("Hibernate.HibernateTranscationManager", "transcationManager");
		        return properties;
		    }
		   @Autowired
		    @Bean(name = "sessionFactory")
		    public SessionFactory getSessionFactory(DataSource dataSource) {

		        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		        sessionBuilder.addProperties(getHibernateProperties());
		        sessionBuilder.addAnnotatedClass(Product.class);
		        sessionBuilder.addAnnotatedClass(Category.class);
		        sessionBuilder.addAnnotatedClass(Cart.class);
		        sessionBuilder.addAnnotatedClass(Order.class);
		        sessionBuilder.addAnnotatedClass(Supplier.class);
		        sessionBuilder.addAnnotatedClass(User.class);
		        return sessionBuilder.buildSessionFactory();
		    }

		    @Autowired
		    @Bean(name = "transactionManager")
		    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		        return transactionManager;
		    }

		    
		    
		  /* @Autowired
		    @Bean(name = "ProductService")
		    public ProductService getProductDAO(SessionFactory sessionFactory) {
		        return new ProductService(sessionFactory);
		    }*/
		    
		   /* @Autowired
		    @Bean(name = "CategoryDAO")
		    public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		        return new CategoryDAOImpl(sessionFactory);
		    }*/
	}
