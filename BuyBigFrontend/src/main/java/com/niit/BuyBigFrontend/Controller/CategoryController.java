package com.niit.BuyBigFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BuyBigBackend.Dao.CategoryDao;
import com.niit.BuyBigBackend.Model.Category;

@Controller

public class CategoryController {
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	

	@RequestMapping("/Category")
	public ModelAndView Category()
	{
		ModelAndView mv= new ModelAndView("cat");
		mv.addObject("category", new Category());
		List<Category> catlist= categoryDao.list();
		mv.addObject("categories",catlist);
		return mv;
		
	}
	
	
	@RequestMapping("/addcat")
	public ModelAndView addcat(@ModelAttribute("category")Category category)
	{
		ModelAndView mv1= new ModelAndView("redirect:/Category");
		if(categoryDao.saveorupdate(category)==true)
		{
			System.out.println("Category is saved");
			mv1.addObject("msg", "Category is saved");
		}
		else
		{
			System.out.println("Category is not saved");
			mv1.addObject("msg", "Category is not saved");
		}
		return mv1;
	}
	

@RequestMapping("/editcat/{catId}")
public ModelAndView editcat(@PathVariable("catId")String catId)
{
	
	category=categoryDao.getCategory(catId);
	ModelAndView mv=new ModelAndView("cat");
	List<Category> catlist=categoryDao.list();
	mv.addObject("category", category);
	mv.addObject("categories", catlist);
	
	return mv;
}
@RequestMapping("/deleteCategory/{catId}")
public ModelAndView deletecat(@PathVariable("catId")String catId)
{
	ModelAndView mv=new ModelAndView("redirect:/Category");
	category=categoryDao.getCategory(catId);
	mv.addObject("category", category);
	List<Category> catlist=categoryDao.list();
	mv.addObject("categories", catlist);
	if(categoryDao.delete(category)==true)
	{
		mv.addObject("msg1","category deleted");
		
	}
	else
	{
		mv.addObject("msg1","category not deleted");
	}
	return mv;
}

}
