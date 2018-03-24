package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.BillingDao;
import com.niit.BuyBigBackend.Model.Billing;
import com.niit.BuyBigBackend.Model.Category;
@Repository("billingDao")
@EnableTransactionManagement
@Transactional
public class BillingDaoImpl implements BillingDao{
	
	@Autowired
	
	SessionFactory sessionfactory;
	public BillingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionfactory=sessionFactory;
	}

	
	public boolean saveorupdate(Billing billing) {
		
		sessionfactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	public boolean delete(Billing billing) {
		sessionfactory.getCurrentSession().delete(billing);
		return true;
	}

	
	public Billing getBilling(String billId) {
		String cat="From Billing where billId='"+billId+"'";
		Query q1=sessionfactory.getCurrentSession().createQuery(cat);
		List<Billing> billlist=(List<Billing>)q1.list();
		if(billlist==null||billlist.isEmpty()) {
		return null;
		}
		return billlist.get(0);
	}

	
	public List<Billing> list() {
		return null;
	}

}
