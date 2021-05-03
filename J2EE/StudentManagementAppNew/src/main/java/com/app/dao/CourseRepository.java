package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Courses;

@Repository
public class CourseRepository implements ICourseDao{

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Courses> listCourses() {
		String jpql = "select c from Courses c";
		
		List<Courses> list = mgr.createQuery(jpql, Courses.class).getResultList();
		System.out.println(list);

		return list	;
	}

	@Override
	public String deleteCourse(int id) {
		
		Courses c = mgr.find(Courses.class, id);
		System.out.println(c);
			mgr.remove(c);
			return "Course deletion successful";
		
		
	}
	
	
}
