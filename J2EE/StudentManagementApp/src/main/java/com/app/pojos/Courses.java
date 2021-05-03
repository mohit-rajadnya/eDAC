package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "courses")
public class Courses extends BaseEntity {

	private String name;
	private double fees;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="start_date")
	private LocalDate startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="start_date")
	private LocalDate endDate;
	@OneToMany(mappedBy = "courses" , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Students> students;
	public Courses(String name, double fees, LocalDate startDate, LocalDate endDate) {
		super();
		this.name = name;
		this.fees = fees;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Courses() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Courses [name=" + name + ", fees=" + fees + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
	
}
