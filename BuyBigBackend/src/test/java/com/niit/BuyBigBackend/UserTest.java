package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.BillingDao;
import com.niit.BuyBigBackend.Dao.UserDao;
import com.niit.BuyBigBackend.Model.Billing;
import com.niit.BuyBigBackend.Model.User;

public class UserTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		Billing billing=(Billing)ctx.getBean("billing");
		BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");
		billing=billingDao.getBilling("b101");
		user.setBilling(billing);
		user.setUserId("us101");
		user.setName("Pooja");
		user.setPassword("123");
		user.setAddress("asswwwwww");
		user.setPhoneNo("1111111111");
		user.setEmailId("abc@gmail.com");
		
		if(userDao.saveorupdate(user)==true) {
			System.out.println("user is saved and scanned");
		}
		else {
			System.out.println("user is not saved and scanned");
	}
		billing=billingDao.getBilling("b102");
		user.setBilling(billing);
		user.setUserId("us102");
		user.setName("Pooja1");
		user.setPassword("1234");
		user.setAddress("asswwwwww111");
		user.setPhoneNo("1111111112");
		user.setEmailId("abce@gmail.com");
		if(userDao.saveorupdate(user)==true) {
			System.out.println("user is saved and scanned");
		}
		else {
			System.out.println("user is not saved and scanned");
	}
		billing=billingDao.getBilling("b102");
		user=userDao.getUser("us101");
		if(userDao.delete(user)==true) {
			System.out.println("user is deleted");
		}
		else {
			System.out.println("user is not deleted");
		}
		user=userDao.getUser("us102");
		if(user==null) {
			System.out.println("user is empty");
		}
		else {
			System.out.println(user.getUserId());
			System.out.println(user.getName());
			System.out.println(user.getPassword());
			System.out.println(user.getAddress());
			System.out.println(user.getPhoneNo());
		}

}
}
