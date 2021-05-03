package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IStudentDao;
import com.app.pojos.Students;

@Service
@Transactional
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	@Override
	public String admitStudent(Students s , int cid) {
		
		return studentDao.admitStudent(s, cid);
	}

}
