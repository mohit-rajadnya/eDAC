package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="students")
public class Students extends BaseEntity{

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public double getCGPA() {
		return CGPA;
	}
	public void setCGPA(double cGPA) {
		CGPA = cGPA;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Students [name=" + name + ", address=" + address + ", DOB=" + DOB + ", CGPA=" + CGPA + ", course="
				+ course + "]";
	}
	public Students(String name, String address, LocalDate dOB, double cGPA) {
		super();
		this.name = name;
		this.address = address;
		DOB = dOB;
		CGPA = cGPA;
	}
	public Students() {
		super();
	}
	private String name;
	private String address;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate DOB;
	private double CGPA;
	@ManyToOne
	@JoinColumn(name="course_id" , nullable=false)
	private Courses course;
	
	
}
