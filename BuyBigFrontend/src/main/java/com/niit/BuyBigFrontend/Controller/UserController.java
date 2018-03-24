package com.niit.BuyBigFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BuyBigBackend.Dao.UserDao;
import com.niit.BuyBigBackend.Model.Category;
import com.niit.BuyBigBackend.Model.User;

@Controller
public class UserController {
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/user")
	public ModelAndView Category()
	{
		ModelAndView mv= new ModelAndView("user");
		mv.addObject("user", new Category());
		List<User> userlist= userDao.list();
		mv.addObject("users",userlist);
		return mv;
		
	}

	@RequestMapping("/adduser")
	public ModelAndView adduser(@ModelAttribute("user")User user)
	{
		ModelAndView mv1= new ModelAndView("redirect:/User");
		if(userDao.saveorupdate(user)==true)
		{
			System.out.println("user is saved");
			mv1.addObject("msg", "user is saved");
		}
		else
		{
			System.out.println("user is not saved");
			mv1.addObject("msg", "user is not saved");
		}
		return mv1;
	}
	

}
