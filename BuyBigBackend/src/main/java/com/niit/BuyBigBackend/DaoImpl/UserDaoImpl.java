package com.niit.BuyBigBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BuyBigBackend.Dao.UserDao;
import com.niit.BuyBigBackend.Model.Supplier;
import com.niit.BuyBigBackend.Model.User;
@Repository("userDao")
@EnableTransactionManagement
@Transactional

public class UserDaoImpl implements UserDao {

     @Autowired
     SessionFactory sessionFactory;
     public UserDaoImpl(SessionFactory sessionFactory)
 	{
 		this.sessionFactory=sessionFactory;
 	}

	
	public boolean saveorupdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		return true;
	}

	
	public boolean delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	
	public User getUser(String userId) {
		String cat="From User where userId='"+userId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(cat);
		List<User> userList=(List<User>)q1.list();
		if(userList==null||userList.isEmpty()) {
		
		return null;
	}
		return userList.get(0);
	}
	
	public List<User> list() {
		
		return null;
	}


}
