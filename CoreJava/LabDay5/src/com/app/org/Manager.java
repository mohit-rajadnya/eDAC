package com.app.org;

public class Manager extends Emp {
	
	private double perfBonus;
	
	public Manager(int empId , String nm , int dptId , double baseSal , double pBonus)
	{
	super(empId , nm , dptId , baseSal);
	perfBonus = pBonus;
	}
	
	public String toString()
	{
		return "Manager : " + super.toString() + " Performance Bonus : " + perfBonus; 
	}

	public double getPerfBonus() {
		return perfBonus;
	}
	
	public double computeNetSal()
	{
		return perfBonus; 
	}
}
