package com.app.org;

public class Worker extends Emp {
	
	private int hoursWorked;
	private double hourlyRate;
	
	public Worker(int empId , String nm , int dptId , double baseSal , int workHr , double hrlyRate)
	{
		super(empId , nm , dptId , baseSal);
		hoursWorked = workHr;
		hourlyRate = hrlyRate;
	}
	
	public String toString()
	{
		return "Worker : " + super.toString() + " Working hours : " + hoursWorked + " Rate per hour: " + hourlyRate;  
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public double computeNetSal()
	{
		return (hoursWorked * hourlyRate); 
	}
}
