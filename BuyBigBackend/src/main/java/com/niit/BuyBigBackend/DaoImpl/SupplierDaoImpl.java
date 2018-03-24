package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.SupplierDao;
import com.niit.BuyBigBackend.Model.Product;
import com.niit.BuyBigBackend.Model.Supplier;
@Repository("supplierDao")
@EnableTransactionManagement
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	
    SessionFactory sessionFactory;
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorupdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
		return true;
	}

	
	public boolean delete(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	
	public Supplier getSupplier(String suppId) {
		String cat="from Supplier where suppId='"+suppId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		
		List<Supplier> suppList=(List<Supplier>)q1.list();
		if(suppList==null||suppList.isEmpty()) {
			 
			
			return null;
		
		}
		 return suppList.get(0);
	}
		
		


	public List<Supplier> list() {
	List<Supplier> supplier=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return supplier;
	
	}
	

}
