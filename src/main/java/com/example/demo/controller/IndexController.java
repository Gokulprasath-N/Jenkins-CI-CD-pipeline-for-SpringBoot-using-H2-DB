package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;

@Controller
public class IndexController {
	
	@Autowired
	UserDAO userdao;

	@RequestMapping("index")
	public String index() {
		return "home";
	}
	
	//post
	@RequestMapping("addUser")
	public String addUser(User user) {
		userdao.save(user);
		return "home";
	}
	
	//Get
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("showUser");
		User user = userdao.findById(id).orElse(new User());
		 
		mav.addObject(user);
		return mav;
	}
	
	
	     //delete
		@RequestMapping("deleteUser")
		public ModelAndView deleteUser(@RequestParam int id) {
			
			ModelAndView mav = new ModelAndView("deleteUser");
			User user = userdao.findById(id).orElse(new User());
			userdao.deleteById(id);
			mav.addObject(user);
			return mav; 
		}
		
		 //put
		@RequestMapping("updateUser")
		public ModelAndView updateUser(User user) {
			
			ModelAndView mav = new ModelAndView("updateUser");
		    user = userdao.findById(user.getId()).orElse(new User());
			userdao.deleteById(user.getId());
			mav.addObject(user);
			return mav; 
		}
	
	
}
