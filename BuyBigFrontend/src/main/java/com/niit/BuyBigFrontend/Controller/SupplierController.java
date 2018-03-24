package com.niit.BuyBigFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BuyBigBackend.Dao.SupplierDao;
import com.niit.BuyBigBackend.Model.Supplier;

import FileInput.FileInput;

@Controller
public class SupplierController {
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/supplier")
	
	public ModelAndView Supplier()
	{
		ModelAndView mv= new ModelAndView("supplier");
		mv.addObject("supplier", new Supplier());
		List<Supplier> supplist= supplierDao.list();
		mv.addObject("supplier", new Supplier());
		mv.addObject("suppliers",supplist);
		return mv;
		
	}
	
 @RequestMapping("/addsupplier")
 public ModelAndView  addsupp(@ModelAttribute("supplier")Supplier supplier)
 {
	 ModelAndView mv=new ModelAndView("redirect:/supplier");
	 mv.addObject("supplier", supplier);
	
	 
	 if(supplierDao.saveorupdate(supplier)==true)
	 {
		
		 mv.addObject("msg", "supplier is saved");
	 }
	 else
	 {
		 mv.addObject("msg", "supplier is not saved");
	 }
	return mv;
	 
 }
 
 @RequestMapping("/editsupp/{suppId}")
 public ModelAndView editsupp(@PathVariable("suppId")String suppId)
 {
	 supplier=supplierDao.getSupplier(suppId);
	 ModelAndView mv=new ModelAndView("supplier");
	 List<Supplier> suppList=supplierDao.list();
	 mv.addObject("supplier", supplier);
	 mv.addObject("suppliers", suppList);
	return mv;
	 
 }
 @RequestMapping("/deletesupply/{suppId}")
	public ModelAndView deletesupply(@PathVariable("suppId")String suppId)
	{
		supplier=supplierDao.getSupplier(suppId);
		ModelAndView mv=new ModelAndView("redirect:/supplier");
		mv.addObject("supplier", supplier);
		 List<Supplier> suppList=supplierDao.list();
		 mv.addObject("suppliers", suppList);
		if(supplierDao.delete(supplier)==true)
		{
			mv.addObject("msg1", "supplier Delete");
		}
		else
		{
			mv.addObject("msg2", "suppliernotdelete");
		}
		return mv;
	}
}
