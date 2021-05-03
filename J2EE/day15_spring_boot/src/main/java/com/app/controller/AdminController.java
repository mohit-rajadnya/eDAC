package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.PaymentMode;
import com.app.pojos.Vendor;
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
	
	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int vid, RedirectAttributes flashMap)
	{
		System.out.println("inside vendor delete " + vid);
		//invoke dao's method for vendor deletion
		flashMap.addFlashAttribute("message", vendorService.deleteVendorDetails(vid));
		return "redirect:/admin/list";
	}
	//add req to show reg form to the client
	//Step1 (2 way data binding/form data binding) : Add empty pojo instance(using def ctor)in model map)
	@GetMapping("/register")
	public String provideRegistrationForm(Model map)
	{
		System.out.println("inside vendor reg form" + getClass().getName());
		map.addAttribute("vendor_details", new Vendor());
		map.addAttribute("payment_modes", PaymentMode.values());
		System.out.println(map);
		return "/admin/register";
	}
	
	//ad request handling method for procesing reg form
	
	@PostMapping("/register")
	public String processRegistration(@ModelAttribute (name="vendor_details") Vendor v,BindingResult res , RedirectAttributes flashMap)
	{
		System.out.println("inside registration method");
		System.out.println("in process reg form : vendor details " + v);
		System.out.println("in process reg form : payment details " + v.getDetails());
		System.out.println("binding result " + res );
		flashMap.addFlashAttribute("message", vendorService.registerVendor(v));
		//after inserting the details : redirect client to vendor list
		return "redirect:/admin/list";
	}
	
	
	
	
}
