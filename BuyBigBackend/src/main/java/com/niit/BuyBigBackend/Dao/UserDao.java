package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.User;

public interface UserDao {

	public boolean saveorupdate(User user);
	
	public boolean delete(User user);
	
	public User getUser(String userId);
	
	public List<User> list();
}
