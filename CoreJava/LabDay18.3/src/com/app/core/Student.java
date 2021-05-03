package com.app.core;

import java.time.LocalDate;

public class Student {

	public int getMarks() {
		return marks;
	}

	public CourseName getCourse() {
		return course;
	}

	private int PRN;
	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getPRN() {
		return PRN;
	}

	private String name;
	private CourseName course;
	private int marks;
	private LocalDate DOB;
	
	public Student(int id ,CourseName course, String nm , int mks , LocalDate dob)
	{
		PRN = id ;
		name = nm ;
		this.course = course;
		marks = mks ;
		DOB = dob;
	}
	
	@Override
	public String toString()
	{
		return "Student ID: " + PRN + " Course: " + course + " Name: " + name + " Marks: " + marks + " Date of Birth: " + DOB;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Student s = (Student) o;
		return PRN == s.PRN ;
	}
	
	@Override
	public int hashCode()
	{
		return PRN;
	}
	
}
