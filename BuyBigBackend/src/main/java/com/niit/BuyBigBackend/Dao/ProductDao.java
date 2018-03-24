package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.Product;

public interface ProductDao {

	public boolean saveorupdate(Product product);
	
	public boolean delete(Product product);
	
	public Product getProduct(String productId);
	
	public List<Product> list();
}
