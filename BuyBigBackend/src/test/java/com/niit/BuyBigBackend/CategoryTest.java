package com.niit.BuyBigBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BuyBigBackend.Dao.CategoryDao;
import com.niit.BuyBigBackend.Model.Category;

public class CategoryTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Category category=(Category)ctx.getBean("category");
		CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
		category.setCatId("c101");
		category.setCatName("Cat1");
		if(categoryDao.saveorupdate(category)==true) {
			System.out.print("successfully created and scanned");
		}
		else
		{
			System.out.println("category not saved");
		}
		category.setCatId("c102");
		category.setCatName("Cat2");
		if(categoryDao.saveorupdate(category)==true) {
			System.out.print("successfully created and scanned");
		}
		else
		{
			System.out.println("category not saved");
		}
		category.setCatId("c103");
		category.setCatName("Cat3");
		if(categoryDao.saveorupdate(category)==true) {
			System.out.print("successfully created and scanned");
		}
		else
		{
			System.out.println("category not saved");
		}
		category=categoryDao.getCategory("c103");
		if(categoryDao.delete(category)==true) {
			System.out.println("category deleted");
		}
		else {
			System.out.println("not deleted");
		}
		category=categoryDao.getCategory("c102");
		if(category==null) {
			System.out.println("empty");
		}
		else {
			System.out.print(category.getCatId());
			System.out.print(category.getCatName());
		}
		
	}
				
}
