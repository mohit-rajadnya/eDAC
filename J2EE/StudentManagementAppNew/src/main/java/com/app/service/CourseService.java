package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICourseDao;
import com.app.pojos.Courses;

@Service
@Transactional
public class CourseService implements ICourseService {

	@Autowired
	private ICourseDao courseDao;
	
	@Override
	public List<Courses> listCourses() {
		
		return courseDao.listCourses();
	}

	@Override
	public String deleteCourse(int id) {
		
		return courseDao.deleteCourse(id);
	}

}
