package com.niit.BuyBigBackend.Configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.BuyBigBackend.Dao.BillingDao;
import com.niit.BuyBigBackend.Dao.CartDao;
import com.niit.BuyBigBackend.Dao.CartItemsDao;
import com.niit.BuyBigBackend.Dao.CategoryDao;
import com.niit.BuyBigBackend.Dao.OrderDao;
import com.niit.BuyBigBackend.Dao.PayDao;
import com.niit.BuyBigBackend.Dao.ProductDao;
import com.niit.BuyBigBackend.Dao.ShippingDao;
import com.niit.BuyBigBackend.Dao.SupplierDao;
import com.niit.BuyBigBackend.Dao.UserDao;
import com.niit.BuyBigBackend.Dao.OrderItemsDao;
import com.niit.BuyBigBackend.DaoImpl.BillingDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.CartDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.CartItemsDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.CategoryDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.OrderDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.PayDaoImpl;
import com.niit.BuyBigBackend.Model.Billing;
import com.niit.BuyBigBackend.Model.Cart;
import com.niit.BuyBigBackend.Model.CartItems;
import com.niit.BuyBigBackend.Model.Category;
import com.niit.BuyBigBackend.Model.Order;
import com.niit.BuyBigBackend.Model.OrderItems;
import com.niit.BuyBigBackend.Model.Pay;
import com.niit.BuyBigBackend.Model.Product;
import com.niit.BuyBigBackend.Model.Shipping;
import com.niit.BuyBigBackend.Model.Supplier;
import com.niit.BuyBigBackend.Model.User;
import com.niit.BuyBigBackend.DaoImpl.ProductDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.ShippingDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.SupplierDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.UserDaoImpl;
import com.niit.BuyBigBackend.DaoImpl.OrderItemsDaoImpl;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext {
  @Bean("dataSource")
  public DataSource getDataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName("org.h2.Driver");
	  dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/Shopping");
	  dataSource.setUsername("pooja");
	  dataSource.setPassword("pooja");
	  return dataSource;
  }
   private Properties getHibernateProperties() {
	  Properties properties = new Properties();
	  properties.put("hibernate.connection.pool_size","10");
	  properties.put("hibernate.hbm2ddl.auto","update");
	  properties.put("hibernate.show_sql","true");
	  properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	  return properties;
	  
   }
   @Autowired
   @Bean("sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource) {
	   LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	   sessionBuilder.addProperties(getHibernateProperties());
	   sessionBuilder.addAnnotatedClass(Category.class);
	   sessionBuilder.addAnnotatedClass(Billing.class);
	   sessionBuilder.addAnnotatedClass(Cart.class);
	   sessionBuilder.addAnnotatedClass(CartItems.class);
	   sessionBuilder.addAnnotatedClass(Order.class);
	   sessionBuilder.addAnnotatedClass(OrderItems.class);
	   sessionBuilder.addAnnotatedClass(Pay.class);
	   sessionBuilder.addAnnotatedClass(Product.class);
	   sessionBuilder.addAnnotatedClass(Shipping.class);
	   sessionBuilder.addAnnotatedClass(Supplier.class);
	   sessionBuilder.addAnnotatedClass(User.class);
	   return sessionBuilder.buildSessionFactory();
	   }
   @Autowired
   @Bean("transactionManager")
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	   HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	   return transactionManager;
	  }
   @Autowired
   @Bean("categoryDao")
   public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
	   return new CategoryDaoImpl(sessionFactory);
	   }
   
   @Autowired
   @Bean("billingDao")
   public BillingDao getBillingDao(SessionFactory sessionFactory) {
	   return new BillingDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("cartDao")
   public CartDao getCartDao(SessionFactory sessionFactory) {
	   return new CartDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("payDao")
   public PayDao getPayDao(SessionFactory sessionFactory) {
	   return new PayDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("productDao")
   public ProductDao getProductDao(SessionFactory sessionFactory) {
	   return new ProductDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("shippingDao")
   public ShippingDao getShippingDao(SessionFactory sessionFactory) {
	   return new ShippingDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("supplierDao")
   public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
	   return new SupplierDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("userDao")
   public UserDao getUserDao(SessionFactory sessionFactory) {
	   return new UserDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("orderItemsDao")
   public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
	   return new OrderItemsDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("cartItemsDao")
   public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) {
	   return new CartItemsDaoImpl(sessionFactory);
   }
   @Autowired
   @Bean("orderDao")
   public OrderDao getOrderDao(SessionFactory sessionFactory) {
	   return new OrderDaoImpl(sessionFactory);
   }
   

}
