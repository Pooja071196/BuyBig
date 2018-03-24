package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.Shipping;

public interface ShippingDao {
public boolean saveorupdate(Shipping shipping);
	
	public boolean delete(Shipping shipping);
	
	public Shipping getShipping(String shippingId);
	
	public List<Shipping> list();

}
