package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.Order;

public interface OrderDao {
public boolean saveorupdate(Order order);
	
	public boolean delete(Order order);
	
public Order getOrderItems(String orderId);
	
	public List<Order> list();
	

}
