package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.ShippingDao;
import com.niit.BuyBigBackend.Model.Shipping;
@Repository("shippingDao")
@EnableTransactionManagement
@Transactional
public class ShippingDaoImpl implements ShippingDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveorupdate(Shipping shipping) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	
	public boolean delete(Shipping shipping) {
		sessionFactory.getCurrentSession().delete(shipping);
		
		return true;
	}

	@Override
	public Shipping getShipping(String shippingId) {
		String cat="From Shipping where shippingId='"+shippingId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		List<Shipping> catlist=(List<Shipping>)q1.list();
		if(catlist==null||catlist.isEmpty()) {
		 
	
		return null;
	}
		
     return catlist.get(0);
	}

	public List<Shipping> list() {
		return null;
	}

}
