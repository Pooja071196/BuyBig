package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.Pay;

public interface PayDao {

	public boolean saveorupdate(Pay pay);
	
	public boolean delete(Pay pay);
	
	public Pay getPay(String payId);
	
	public List<Pay> list();
}
