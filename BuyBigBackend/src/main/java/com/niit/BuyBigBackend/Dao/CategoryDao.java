package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.Category;

public interface CategoryDao {

	public boolean saveorupdate(Category category);
	
	public boolean delete(Category category);
	
	public Category getCategory(String catId);
	
	public List<Category> list();
	
}