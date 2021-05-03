package com.app.utils;

import java.util.HashMap;

import com.app.core.CourseName;
import com.app.core.Student;
import com.app.custom_exception.CustomException;

public class StudentValidations {
	
	public static void validateStudent(HashMap<Integer, Student> s , Integer p) throws CustomException
	{
		if(s.containsKey(p))
			throw new CustomException("Duplicate student PRN found. PRN needs to be unique!!");
	}
	
	public static Student checkIfExist(HashMap<Integer, Student> s , Integer p) throws CustomException
	{
		Student temp = s.get(p);
		if(temp == null)
			throw new CustomException("Student already exists!!!");
		
		return temp;
	}
	
	public static void validateCourseName(CourseName c) throws CustomException
	{
		boolean flag = false;
		for(CourseName nm : CourseName.values())
			if (c == nm)
				{
				flag = true;
				break;
				}
		if(!flag)
			throw new CustomException("Course not found!!");
				
	}

}
