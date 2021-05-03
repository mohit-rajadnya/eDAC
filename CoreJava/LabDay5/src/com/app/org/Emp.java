package com.app.org;

public abstract class Emp {

	private int id;
	private String name;
	private int deptId;
	private double basicSal;
	
	
	public Emp(int id, String name, int deptId, double basicSal) 
	{
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.basicSal = basicSal;
	}
	
	//Get details of emp class
	public String toString()
	{
		return " ID " + id + " Name: " + name + " deptId: " + deptId + " basic: " + basicSal;
	}
	
	//compute net salary
	public abstract double computeNetSal();
	
}
