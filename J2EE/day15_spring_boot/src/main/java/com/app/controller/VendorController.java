package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	 public VendorController()
	 {
		System.out.println("inside ctor of " + getClass().getName()); 
	 }
	 //add a request handling method to fwd client to vendor details page
	 @GetMapping("/details")
	 public String showVendorDetails()
	 {
		 System.out.println("inside vendor details");
		 return "/vendor/details";//logical view name.. Actual name = "WEB-INF/views/vendor/details"
	 }
}
