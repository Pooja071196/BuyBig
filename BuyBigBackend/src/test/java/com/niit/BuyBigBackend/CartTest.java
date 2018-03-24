package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.CartDao;
import com.niit.BuyBigBackend.Model.Cart;

public class CartTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartDao=(CartDao)ctx.getBean("cartDao");
		cart.setCartId("ca101");
		cart.setGrandTotal(26.0);
		cart.setTotalItems(7);
		if(cartDao.saveorupdate(cart)==true) {
			System.out.println("Cart is saved and scanned");
			
	}
		else {
			System.out.println("not scanned");
		}
		
		cart.setCartId("ca102");
		cart.setGrandTotal(30.0);
		cart.setTotalItems(9);
		if(cartDao.saveorupdate(cart)==true) {
			System.out.println("Cart is saved and scanned");
			
	}
		else {
			System.out.println("not scanned");
		}
		cart=cartDao.getCart("ca101");
		if(cartDao.delete(cart)==true) {
			System.out.println("cart deleted");
		}
		else {
			System.out.println("cart not deleted");
		}
		cart=cartDao.getCart("ca102");
		if(cart==null) {
			System.out.println("cart not found");
		}
		else {
			System.out.println(cart.getCartId());
			System.out.println(cart.getGrandTotal());
			System.out.println(cart.getTotalItems());
		}
	}

}
