package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Model.Supplier;
import com.niit.BuyBigBackend.Dao.SupplierDao;;

public class SuppierTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Supplier supplier=(Supplier)ctx.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
		supplier.setSuppID("su101");
		supplier.setSuppName("Atrica");
		supplier.setAddress("abcdef");
		supplier.setEmail("abc@gmail.com");
		supplier.setPhno("123456789");
		if(supplierDao.saveorupdate(supplier)==true) {
			System.out.println("supplier is saved and scanned");
		}
		else {
			System.out.println("supplier is not saved and scanned");
		}
		supplier.setSuppID("su102");
		supplier.setSuppName("Atrica1");
		supplier.setAddress("abcdefgh");
		supplier.setEmail("abcde@gmail.com");
		supplier.setPhno("123456799");
		if(supplierDao.saveorupdate(supplier)==true) {
			System.out.println("supplier is saved and scanned");
		}
		else {
			System.out.println("supplier is not saved and scanned");
		}
		supplier=supplierDao.getSupplier("su101");
		if(supplierDao.delete(supplier)==true) {
			System.out.println("supplier is deleted");
		}
		else {
			System.out.println("supplier is not deleted");
		}
		supplier=supplierDao.getSupplier("su102");
		if(supplier==null) {
			System.out.println("supplier is empty");
		}
		else {
			System.out.println(supplier.getSuppID());
			System.out.println(supplier.getSuppName());
			System.out.println(supplier.getPhno());
			System.out.println(supplier.getAddress());
			System.out.println(supplier.getEmail());
		}
		
	}

}
