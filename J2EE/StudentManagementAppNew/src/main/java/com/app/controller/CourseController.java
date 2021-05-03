package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.ICourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private ICourseService courseService;

	@GetMapping("/list")
	public String showList(Model map)
	{
		map.addAttribute("course_list", courseService.listCourses());
		return "/course/list";
	}
	
	@GetMapping("/delete")
	public String deleteCourse(RedirectAttributes map , @RequestParam int cid)
	{
		
		String message =  courseService.deleteCourse(cid);
		map.addFlashAttribute("message", message);
		map.addFlashAttribute("course_list", courseService.listCourses());
		return "redirect:/course/list";
	}
}
