package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.BillingDao;
import com.niit.BuyBigBackend.Dao.OrderDao;
import com.niit.BuyBigBackend.Dao.ShippingDao;
import com.niit.BuyBigBackend.Dao.UserDao;
import com.niit.BuyBigBackend.Model.Billing;
import com.niit.BuyBigBackend.Model.Order;
import com.niit.BuyBigBackend.Model.Shipping;
import com.niit.BuyBigBackend.Model.User;

public class OrderTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Order order=(Order)ctx.getBean("order");
		OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
		Billing billing=(Billing)ctx.getBean("billing");
		BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");
		Shipping shipping=(Shipping)ctx.getBean("shipping");
		ShippingDao shippingDao=(ShippingDao)ctx.getBean("shippingDao");
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		billing=billingDao.getBilling("b102");
		shipping=shippingDao.getShipping("sh102");
		user=userDao.getUser("us102");
		order.setUser(user);
		order.setShipping(shipping);
		order.setBilling(billing);
		order.setOrderId("or101");
		order.setGrandTotal("123");
		order.setOrderDate("2nd nov 2017");
		order.setOrderTime("5:00pm");
		if(orderDao.saveorupdate(order)==true) {
			System.out.println("order is saved and scanned");
		}
		else {
			System.out.println("order is saved and scanned");
		}
		billing=billingDao.getBilling("b102");
		shipping=shippingDao.getShipping("sh102");
		user=userDao.getUser("us102");
		
		
		order.setBilling(billing);
		order.setShipping(shipping);
		order.setUser(user);
		order.setOrderId("or102");
		order.setGrandTotal("123");
		order.setOrderDate("3rd Aug 2017");
		order.setOrderTime("6:00pm");
		if(orderDao.saveorupdate(order)==true) {
			System.out.println("order is saved and scanned");
		}
		else {
			System.out.println("order is saved and scanned");
		}
		order=orderDao.getOrderItems("or101");
		if(orderDao.delete(order)==true) {
			System.out.println("order is deleted");
		}
		else {
			System.out.println("order is not deleted");
		}
		order=orderDao.getOrderItems("or102");
		if(order==null) {
			System.out.println("order is empty");
		}
		else {
			System.out.println(order.getOrderId());
			System.out.println(order.getGrandTotal());
			System.out.println(order.getOrderDate());
			System.out.println(order.getOrderTime());
			
		}
	}

}
