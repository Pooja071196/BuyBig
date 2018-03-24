package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.OrderDao;
import com.niit.BuyBigBackend.Model.Category;
import com.niit.BuyBigBackend.Model.Order;
@Repository("orderDao")
@EnableTransactionManagement
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	
	SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	public boolean saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}


	public boolean delete(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		
		return true;
	}

	
	public Order getOrderItems(String orderId) {
		String cat="From Order where orderId='"+orderId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		List<Order> catlist=(List<Order>)q1.list();
		if(catlist==null||catlist.isEmpty()) {
		
	
		return null;
	}
		
     return catlist.get(0);
	}

	
	public List<Order> list() {
	
		return null;
	}

}
