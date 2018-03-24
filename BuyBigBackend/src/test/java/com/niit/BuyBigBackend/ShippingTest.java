package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.ShippingDao;
import com.niit.BuyBigBackend.Dao.UserDao;
import com.niit.BuyBigBackend.Model.Shipping;
import com.niit.BuyBigBackend.Model.User;

public class ShippingTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Shipping shipping=(Shipping)ctx.getBean("shipping");
		ShippingDao shippingDao=(ShippingDao)ctx.getBean("shippingDao");
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		user=userDao.getUser("us102");
		shipping.setUser(user);
		shipping.setShippingId("sh101");
		shipping.setFirstName("Abc");
		shipping.setLastName("efg");
		shipping.setCountry("India");
		shipping.setHouseNo("123");
		if(shippingDao.saveorupdate(shipping)==true) {
			System.out.println("Shipping is saved and scanned");
		}
		else {
			System.out.println("Shipping is not saved and scanned");
		}
		user=userDao.getUser("us102");
		shipping.setUser(user);
		shipping.setShippingId("sh102");
		shipping.setFirstName("DEc");
		shipping.setLastName("efg");
		shipping.setCountry("India");
		shipping.setHouseNo("124");
		if(shippingDao.saveorupdate(shipping)==true) {
			System.out.println("Shipping is saved and scanned");
		}
		else {
			System.out.println("Shipping is not saved and scanned");
		}
		shipping=shippingDao.getShipping("sh101");
		if(shippingDao.delete(shipping)==true) {
			System.out.println("Shipping is deleted");
		}
		else {
			System.out.println("Shipping is not deleted");
		}
		shipping=shippingDao.getShipping("sh102");
		if(shipping==null) {
			System.out.println("Shipping is empty");
		}
		else {
			System.out.println(shipping.getShippingId());
			System.out.println(shipping.getFirstName());
			System.out.println(shipping.getLastName());
			System.out.println(shipping.getHouseNo());
			System.out.println(user.getUserId());
		}
	}

}
