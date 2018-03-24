package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.PayDao;
import com.niit.BuyBigBackend.Model.Category;
import com.niit.BuyBigBackend.Model.Pay;
@Repository("payDao")
@EnableTransactionManagement
@Transactional
public class PayDaoImpl implements PayDao{
	
	@Autowired
	
	SessionFactory sessionFactory;
	public PayDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	public boolean saveorupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}


	public boolean delete(Pay pay) {
		sessionFactory.getCurrentSession().delete(pay);
		return true;
	}

	
	public Pay getPay(String payId) {
		String cat="From Pay where payId='"+payId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		List<Pay> catlist=(List<Pay>)q1.list();
		if(catlist==null||catlist.isEmpty()) {
		 
	
		return null;
	}
		
     return catlist.get(0);
	}


	public List<Pay> list() {
		
		return null;
	}

}
