package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.CartItemsDao;
import com.niit.BuyBigBackend.Model.CartItems;
import com.niit.BuyBigBackend.Model.Category;
@Repository("cartItemsDao")
@EnableTransactionManagement
@Transactional
public class CartItemsDaoImpl implements CartItemsDao {

	@Autowired
	 
	SessionFactory sessionFactory;
	public CartItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(CartItems cartitems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
		
		return true;
	}

	
	public boolean delete(CartItems cartitems) {
		sessionFactory.getCurrentSession().delete(cartitems);
		
		return true;
	}

	public CartItems getCartItems(String cartItemsId) {
		
		String cat="From CartItems where cartItemsId='"+cartItemsId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		List<CartItems> catlist=(List<CartItems>)q1.list();
		if(catlist==null||catlist.isEmpty()) {
		 
	
		return null;
	}
		
     return catlist.get(0);
	}


	public List<CartItems> list() {
		
		return null;
	}

}
