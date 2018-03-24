package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.PayDao;
import com.niit.BuyBigBackend.Model.Pay;

public class PayTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Pay pay=(Pay)ctx.getBean("pay");
		PayDao payDao=(PayDao)ctx.getBean("payDao");
		pay.setPayId("p101");
		pay.setPayementStatus("processing:");
		pay.setPayementMethod("cash");
		if(payDao.saveorupdate(pay)==true) {
			System.out.println("payement saved and scanned");
		}
		else {
			System.out.println("payement not saved and scanned");
		}
		pay.setPayId("p102");
		pay.setPayementStatus("processing:");
		pay.setPayementMethod("cash");
		if(payDao.saveorupdate(pay)==true) {
			System.out.println("payement saved and scanned");
		}
		else {
			System.out.println("payement not saved and scanned");
		}
		pay=payDao.getPay("p101");
		if(payDao.delete(pay)==true) {
			System.out.println("payement deleted");
		}
		else {
			System.out.println("payement not deleted");
		}
		pay=payDao.getPay("p102");
		if(pay==null) {
			System.out.println("pay is empty");
		}
		else {
			System.out.println(pay.getPayementMethod());
			System.out.println(pay.getPayementStatus());
			System.out.println(pay.getPayId());
		}
		
	}

}
