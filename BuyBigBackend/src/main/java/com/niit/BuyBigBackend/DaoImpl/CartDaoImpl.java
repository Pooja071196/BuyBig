package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.CartDao;
import com.niit.BuyBigBackend.Model.Cart;
import com.niit.BuyBigBackend.Model.Category;
@Repository("cartDao")
@EnableTransactionManagement
@Transactional

public class CartDaoImpl implements CartDao {
	
	@Autowired
	
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorupdate(Cart cart) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	
	public boolean delete(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		
		return true;
	}

	
	public Cart getCart(String cartId) {
		String cat="From Cart where cartId='"+cartId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		List<Cart> catlist=(List<Cart>)q1.list();
		if(catlist==null||catlist.isEmpty()) {
		 return null;
	}
		
     return catlist.get(0);
	}

	
	public List<Cart> list() {
		return null;
	}

}
