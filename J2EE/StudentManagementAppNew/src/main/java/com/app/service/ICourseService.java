package com.app.service;

import java.util.List;

import com.app.pojos.Courses;

public interface ICourseService {

	List<Courses> listCourses();
	String deleteCourse(int id);
}
