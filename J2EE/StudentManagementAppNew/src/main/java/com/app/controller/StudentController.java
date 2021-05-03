package com.app.controller;

import javax.servlet.http.HttpSession;

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

import com.app.pojos.Students;
import com.app.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/admit")
	public String showStudentAdmissionForm(@RequestParam int cid,Students s, HttpSession hs)
	{
		hs.setAttribute("cid", cid);
		return "/student/admit";
	}
	
	@PostMapping("/admit")
	public String admitStudent(@ModelAttribute Students s , BindingResult res , Model map , RedirectAttributes flashmap, HttpSession hs)
	{
		System.out.println("student details" + s);//for debugging
		System.out.println("Binding res" + res);//for debugging
		if(s.getCGPA()>7 && s.getDOB().getYear() > 1990)
		{	
			int cid = (int)hs.getAttribute("cid");
			flashmap.addFlashAttribute("message", studentService.admitStudent(s , cid));
			hs.invalidate();
			return "redirect:/course/list";
		}
		else
		{
			map.addAttribute("message", "Failed to admit student!! CGPA should be greater than 7 and Birth Year > 1990!!");
			return "/student/admit";
		}
		
	}
}
