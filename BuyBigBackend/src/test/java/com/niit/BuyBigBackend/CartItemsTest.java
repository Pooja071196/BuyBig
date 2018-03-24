package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.CartDao;
import com.niit.BuyBigBackend.Dao.CartItemsDao;
import com.niit.BuyBigBackend.Dao.ProductDao;
import com.niit.BuyBigBackend.Model.Cart;
import com.niit.BuyBigBackend.Model.CartItems;
import com.niit.BuyBigBackend.Model.Product;

public class CartItemsTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		CartItems cartItems=(CartItems)ctx.getBean("cartItems");
		CartItemsDao cartItemsDao=(CartItemsDao)ctx.getBean("cartItemsDao");
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartDao=(CartDao)ctx.getBean("cartDao");
		Product product=(Product)ctx.getBean("product");
		ProductDao productDao=(ProductDao)ctx.getBean("productDao");
		
		
		
		cart=cartDao.getCart("ca102");
		product=productDao.getProduct("pr102");
		cartItems.setProduct(product);
		cartItems.setCart(cart);
		cartItems.setCartItemsId("ci101");
		cartItems.setPrice(100);
		if(cartItemsDao.saveorupdate(cartItems)==true) {
			System.out.println("Cart items saved and scanned");
		}
		else {
			System.out.println("Cart items not saved and scanned");
		}
		product=productDao.getProduct("pr102");
		cart=cartDao.getCart("ca102");
		cartItems.setProduct(product);
		cartItems.setCart(cart);
		cartItems.setCartItemsId("ci102");
		cartItems.setPrice(100);
		if(cartItemsDao.saveorupdate(cartItems)==true) {
			System.out.println("Cart items saved and scanned");
		}
		else {
			System.out.println("Cart items not saved and scanned");
		}
		cartItems=cartItemsDao.getCartItems("ci101");
		if(cartItemsDao.delete(cartItems)==true) {
			System.out.println("Cart items are deleted");
		}
		else {
			System.out.println("Cart items not deleted");
		}
		cartItems=cartItemsDao.getCartItems("ci102");
		if(cartItems==null) {
			System.out.println("Cart items are empty");
		}
		else {
			System.out.println(cartItems.getCartItemsId());
			System.out.println(cartItems.getPrice());
			System.out.println(cartItems.getCart());
		}
	}

}
