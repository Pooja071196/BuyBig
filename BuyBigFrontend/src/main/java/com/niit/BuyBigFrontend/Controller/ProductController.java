package com.niit.BuyBigFrontend.Controller;

import org.springframework.stereotype.Controller;

import com.niit.BuyBigBackend.Dao.CategoryDao;
import com.niit.BuyBigBackend.Dao.ProductDao;
import com.niit.BuyBigBackend.Dao.SupplierDao;
import com.niit.BuyBigBackend.Model.Category;
import com.niit.BuyBigBackend.Model.Product;
import com.niit.BuyBigBackend.Model.Supplier;

import FileInput.FileInput;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
   @Autowired
   Product product;
   
   @Autowired
   ProductDao productDao;
   
   @Autowired
   Category category;
   
   @Autowired
   CategoryDao categoryDao;
   
   @Autowired
   Supplier supplier;
   
   @Autowired
   SupplierDao supplierDao;
   
   String path="C:\\Users\\Poo\\eclipse-workspace\\BuyBigFrontend\\src\\main\\webapp\\resources\\images\\"; 
   
   @RequestMapping("/product")
   public ModelAndView Product()
   {
	   ModelAndView mv=new ModelAndView("product");
	   List<Product> prodlist=productDao.list();
	   List<Category> catlist=categoryDao.list();
	   List<Supplier> supplist=supplierDao.list();
	   mv.addObject("product", new Product());
	   mv.addObject("products", prodlist);
	   mv.addObject("categories", catlist);
	   mv.addObject("suppliers", supplist);
	  
	return mv;
	   
   }
	@RequestMapping("/addproduct")
	public ModelAndView addproduct(@ModelAttribute("product")Product product)
	{
		ModelAndView mv1= new ModelAndView("redirect:/product");
		mv1.addObject("product", product);
		String path="C:\\Users\\Poo\\eclipse-workspace\\BuyBigFrontend\\src\\main\\webapp\\resources\\images\\";
		if(productDao.saveorupdate(product)==true)
		{
			FileInput.upload(path,product.getPimg(),product.getProductId()+".jpg");
			System.out.println("product is saved");
			mv1.addObject("msg", "product is saved");
		}
		else
		{
			System.out.println("product is not saved");
			mv1.addObject("msg", "product is not saved");
		}
		return mv1;
	}
	@RequestMapping("/editproduct/{productId}")
	public ModelAndView editproduct(@PathVariable("productId")String productId)
	{
		product=productDao.getProduct(productId);
		ModelAndView mv=new ModelAndView("product");
		mv.addObject("product", product);
		List<Product> productlist=productDao.list();
		List<Category> catlist=categoryDao.list();
		   List<Supplier> supplist=supplierDao.list();
		mv.addObject("products", productlist);
		  mv.addObject("categories", catlist);
		   mv.addObject("suppliers", supplist);
		  
	
		return mv;
	}
	@RequestMapping("/deleteProduct/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId")String productId)
	{
		
		product=productDao.getProduct(productId);
		ModelAndView mv=new ModelAndView("redirect:/product");
		mv.addObject("product", product);
		List<Product> productlist=productDao.list();
		mv.addObject("products", productlist);
		if(productDao.delete(product)==true)
		{
			mv.addObject("msg1","product deleted");
			
		}
		else
		{
			mv.addObject("msg1","product not deleted");
		}
		return mv;
	}
	
   
   
}
