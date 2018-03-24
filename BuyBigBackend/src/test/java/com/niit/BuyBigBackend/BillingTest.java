package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.BillingDao;
import com.niit.BuyBigBackend.Dao.UserDao;
import com.niit.BuyBigBackend.Model.Billing;
import com.niit.BuyBigBackend.Model.User;

public class BillingTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Billing billing=(Billing)ctx.getBean("billing");
		BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");
		User user= (User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		user=userDao.getUser("us102");
		billing.setUser(user);
		billing.setBillId("b101");
		billing.setCity("Bangalore");
		billing.setEmail("abc@gmail.com");
		billing.setHouseNo("001");
		billing.setMobNo("9999999999");
		billing.setPinCode("560010");
		
		if(billingDao.saveorupdate(billing)==true) {
			System.out.println("Successfully created and scanned");
			
		}
		else {
			System.out.println("Not Scanned");
		}
		
		user=userDao.getUser("us102");
		billing.setUser(user);
		billing.setBillId("b102");
		billing.setCity("Bangalore");
		billing.setEmail("abcd@gmail.com");
		billing.setHouseNo("002");
		billing.setMobNo("9999999998");
		billing.setPinCode("560010");
		if(billingDao.saveorupdate(billing)==true) {
			System.out.println("Successfully created and scanned");
			
		}
		else {
			System.out.println("Not Scanned");
		}
		billing=billingDao.getBilling("b101");
		if(billingDao.delete(billing)==true) {
			System.out.println("Successfully deleted");
		}
		else {
			System.out.println("not deleted");	
		}
		billing=billingDao.getBilling("b102");
		if(billing==null) {
			System.out.println("empty");
		}
		else {
			System.out.println(billing.getBillId());
			System.out.println(billing.getCity());
			System.out.println(billing.getEmail());
			System.out.println(billing.getHouseNo());
			System.out.println(billing.getMobNo());
			System.out.println(billing.getPinCode());
		}
		
		
	}

}
