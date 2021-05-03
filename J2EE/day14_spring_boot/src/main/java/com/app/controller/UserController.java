package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IVendorService vendorService;

	public UserController()
	{
		System.out.println("in ctor of " + getClass().getName() + " " + vendorService);
	}
	
	@PostConstruct
	public void anyInit()
	{
		System.out.println("in init of " + getClass().getName() + " " + vendorService);
	}
	
	//add request handling method for 
	@GetMapping("/login")
	//key: /user/login :method=get
	public String provideLoginPage()
	{
		System.out.println("in login form");
		return "/user/login";//for separation
	}
	//add a req handlign method to validate the form
	@PostMapping("/login")
	//key: /user/login :method=post
	public String processLoginForm(@RequestParam String email , @RequestParam String pass, Model modelMap, HttpSession hs)
	{
		System.out.println("in process login " + email + " " + pass);
		try {
		//invoke service layer method for B.L
		Vendor user = vendorService.autheticateUser(email, pass);
		//save validated user details under session scope
		hs.setAttribute("user_dtls", user);
		hs.setAttribute("message", user.getUserRole()+" " + user.getName() + " has logged in!! " );
		if(user.getUserRole().equals(Role.ADMIN))
			return "redirect:/admin/list";
		
		if(user.getUserRole().equals(Role.VENDOR))
			return "redirect:/vendor/details";
		
		}catch (Exception e) {
			//add error message to model map
			modelMap.addAttribute("message", "Invalid login , please try again");
			System.out.println("Error in controller " + e);//javax.persistence.NoResultException
			return "/user/login";
		}
		return null;
	}
}
