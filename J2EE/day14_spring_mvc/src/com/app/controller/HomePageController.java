package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	public HomePageController()
	{
		System.out.println("In ctor " + getClass().getName());
	}
	
	//add req handling method to provide home page
	@RequestMapping
	public String provideHomePage()
	{
		System.out.println("in show home page");
		return "/index";
	}
}
