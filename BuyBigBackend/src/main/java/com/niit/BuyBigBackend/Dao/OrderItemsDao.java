package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.OrderItems;

public interface OrderItemsDao {
	
	public boolean saveorupdate(OrderItems orderitems);
	
	public boolean delete(OrderItems orderitems);
	
public OrderItems getOrderItems(String orderItemsId);
	
	public List<OrderItems> list();
	

}
