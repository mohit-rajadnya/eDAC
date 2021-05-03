package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IVendorService vendorService;
	
	public AdminController()
	{
		System.out.println("in ctor of " + getClass().getName());
	
	}
	
	@PostConstruct
	public void anyInit()
	{
		System.out.println("in side init of " + getClass().getName());
	}
	
	@GetMapping("/list")
	public String provideVendorList(Model modelMap)
	{
		System.out.println("inside vendor list page");
		//invoke service layer method to get all list n save it in model map attribute ro navigate clietn to view layer
		modelMap.addAttribute("vList", vendorService.listVendors());
		return "/admin/list";
	}
}
