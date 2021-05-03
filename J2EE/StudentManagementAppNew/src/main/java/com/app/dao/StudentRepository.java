package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Courses;
import com.app.pojos.Students;

@Repository
public class StudentRepository implements IStudentDao {
	
	@Autowired
	private EntityManager mgr;

	@Override
	public String admitStudent(Students s, int cid) {
		
		Courses c = mgr.find(Courses.class, cid);
		s.setCourse(c);
		mgr.persist(s);
		
		return "Student admission successful!!";
	}

}
