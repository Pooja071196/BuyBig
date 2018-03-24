package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.Supplier;

public interface SupplierDao {
	
	public boolean saveorupdate(Supplier supplier);
	
	public boolean delete(Supplier supplier);
	
	public Supplier getSupplier(String suppId);
	
	public List<Supplier> list();

}
