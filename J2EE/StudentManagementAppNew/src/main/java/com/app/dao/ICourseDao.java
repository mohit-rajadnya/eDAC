package com.app.dao;

import java.util.List;

import com.app.pojos.Courses;

public interface ICourseDao {
	
	List<Courses> listCourses();
	String deleteCourse(int id);
}
