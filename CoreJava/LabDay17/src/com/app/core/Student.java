package com.app.core;

import java.time.LocalDate;

public class Student {

	private int Id;
	private String course , name;
	private int marks;
	private LocalDate DOB;
	
	public Student(int id ,String course, String nm , int mks , LocalDate dob)
	{
		Id = id ;
		name = nm ;
		this.course = course;
		marks = mks ;
		DOB = dob;
	}
	
	@Override
	public String toString()
	{
		return "Student ID: " + Id + " Course: " + course + " Name: " + name + " MArks: " + marks + " Date of Birth: " + DOB;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Student s = (Student) o;
		return Id == s.Id;
	}
	
	@Override
	public int hashCode()
	{
		return Id;
	}
}
