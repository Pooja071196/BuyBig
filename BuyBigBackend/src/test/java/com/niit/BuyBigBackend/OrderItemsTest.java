package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.OrderDao;
import com.niit.BuyBigBackend.Dao.OrderItemsDao;
import com.niit.BuyBigBackend.Dao.PayDao;
import com.niit.BuyBigBackend.Model.Order;
import com.niit.BuyBigBackend.Model.OrderItems;
import com.niit.BuyBigBackend.Model.Pay;

public class OrderItemsTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		OrderItems orderItems=(OrderItems)ctx.getBean("orderItems");
		OrderItemsDao orderItemsDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
		Pay pay=(Pay)ctx.getBean("pay");
		PayDao payDao=(PayDao)ctx.getBean("payDao");
		Order order=(Order)ctx.getBean("order");
		OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
		order=orderDao.getOrderItems("or102");
		
		
		pay=payDao.getPay("p102");
		orderItems.setOrder(order);
		orderItems.setPay(pay);
		orderItems.setOrderItemsId("or101");
		orderItems.setProductId("pr101");
		if(orderItemsDao.saveorupdate(orderItems)==true) {
			System.out.println("order is saved and scanned");
		}
		else {
			System.out.println("order is not saved and scanned");
		}
		order=orderDao.getOrderItems("or102");
		pay=payDao.getPay("p102");
		orderItems.setOrder(order);
	    orderItems.setPay(pay);
		orderItems.setOrderItemsId("or102");
		orderItems.setProductId("pr102");
		if(orderItemsDao.saveorupdate(orderItems)==true) {
			System.out.println("order is saved and scanned");
		}
		else {
			System.out.println("order is not saved and scanned");
		}
		orderItems=orderItemsDao.getOrderItems("or101");
		if(orderItemsDao.delete(orderItems)==true) {
			System.out.println("order is deleted");
			
		}
		else {
			System.out.println("order is not deleted");
		}
		orderItems=orderItemsDao.getOrderItems("or102");
		if(orderItems==null) {
			System.out.println("OrderItems is empty");
		}
		else {
			System.out.println(orderItems.getOrderItemsId());
			System.out.println(orderItems.getProductId());
			System.out.println(orderItems.getPay());
		}
	}

}
