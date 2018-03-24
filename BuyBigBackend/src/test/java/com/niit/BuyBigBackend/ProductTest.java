package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.CategoryDao;
import com.niit.BuyBigBackend.Dao.ProductDao;
import com.niit.BuyBigBackend.Dao.SupplierDao;
import com.niit.BuyBigBackend.Model.Category;
import com.niit.BuyBigBackend.Model.Product;
import com.niit.BuyBigBackend.Model.Supplier;

public class ProductTest {
public static void main(String args[]) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	Product product=(Product)ctx.getBean("product");
	ProductDao productDao=(ProductDao)ctx.getBean("productDao");
	Category category=(Category)ctx.getBean("category");
	CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
	Supplier supplier=(Supplier)ctx.getBean("supplier");
	SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
	supplier=supplierDao.getSupplier("su102");
	category=categoryDao.getCategory("c102");
	product.setSupplier(supplier);
	product.setCategory(category);
	product.setProductId("pr101");
	product.setName("Tshirt");
	product.setDescription("Red");
	product.setPrice(100);
	product.setQuantity(10);
	if(productDao.saveorupdate(product)==true) {
		System.out.println("product saved and scanned");
	}
	else {
		System.out.println("product not saved and scanned");
	}
	supplier=supplierDao.getSupplier("su102");
	category=categoryDao.getCategory("c102");
	product.setSupplier(supplier);
	product.setCategory(category);
	product.setProductId("pr102");
	product.setName("Tshirt");
	product.setDescription("pink");
	product.setPrice(100);
	product.setQuantity(10);
	if(productDao.saveorupdate(product)==true) {
		System.out.println("product saved and scanned");
	}
	else {
		System.out.println("product not saved and scanned");
	}
	product=productDao.getProduct("pr101");
	if(productDao.delete(product)==true) {
		System.out.println("product deleted");
	}
	else {
		System.out.println("product not deleted");
	}
	product=productDao.getProduct("pr102");
	if(product==null) {
		System.out.println("product is empty");
	}
	else {
		System.out.println(product.getProductId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		System.out.println(product.getDescription());
	}
}
}
