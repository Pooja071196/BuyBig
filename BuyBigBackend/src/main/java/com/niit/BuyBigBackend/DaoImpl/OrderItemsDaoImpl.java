package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.OrderItemsDao;
import com.niit.BuyBigBackend.Model.CartItems;
import com.niit.BuyBigBackend.Model.OrderItems;
@Repository("orderItemsDao")
@EnableTransactionManagement
@Transactional
public class OrderItemsDaoImpl implements OrderItemsDao {

	@Autowired
	
	SessionFactory sessionFactory;
	public OrderItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveorupdate(OrderItems orderitems) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(orderitems);
		return true;
	}

	
	public boolean delete(OrderItems orderitems) {
		sessionFactory.getCurrentSession().delete(orderitems);
		
		return true;
	}

	
	public OrderItems getOrderItems(String orderItemsId) {
		
		
		String cat="From OrderItems where orderItemsId='"+orderItemsId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		List<OrderItems> catlist=(List<OrderItems>)q1.list();
		if(catlist==null||catlist.isEmpty()) {
		 
	
		return null;
	}
		
     return catlist.get(0);
	}

	
	public List<OrderItems> list() {

		return null;
	}

}
