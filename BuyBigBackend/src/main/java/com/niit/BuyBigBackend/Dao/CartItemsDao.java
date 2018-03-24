package com.niit.BuyBigBackend.Dao;

import java.util.List;

import com.niit.BuyBigBackend.Model.CartItems;

public interface CartItemsDao {

public boolean saveorupdate(CartItems cartitems);
	
	public boolean delete(CartItems cartitems);
	
	public CartItems getCartItems(String cartItemsId);
	
	public List<CartItems> list();
}
