package com.app.tester;

import java.util.Scanner;

import com.app.org.Manager;
import com.app.org.Worker;

public class TestOrganization {
	
	static int MId = 100;
	static int WId = 500;
	
	
	
	public static void main(String args[])
	{	
		
		Manager[] m = new Manager[100];
		Worker[] w = new Worker[100];
		int indexM = 0;
		int indexW = 0;
		
		Scanner sc = new Scanner (System.in);
		
		
		boolean exit = true;
		
		while(exit)
		{
			System.out.println("1. Hire Manager \n 2. Hire Worker \n 3.Show all details \n 4.Exit");
			System.out.println("Select your choice");
			
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Name , DeptID , Basic Sal , PerfBonus");
					m[indexM] = new Manager(MId , sc.next(), sc.nextInt(),sc.nextDouble() , sc.nextDouble());
					indexM++;
					MId++;
					break;
					
			case 2: System.out.println("Name , DeptID , Basic Sal , WorkingHours , HourlyRate");
					w[indexW] = new Worker(WId , sc.next(), sc.nextInt(),sc.nextDouble() , sc.nextInt() , sc.nextDouble());
					indexW++;
					WId++;
					break;
			
			case 3: System.out.println("Manager: ");
					for (int i=0 ; i<indexM ; i++)
					{
					System.out.println(m[i].toString());
					System.out.println("Net Salary: " + m[i].computeNetSal());
					}
					System.out.println();
					System.out.println("Workers:");
					for (int i=0 ; i<indexW ; i++)
					{
					System.out.println(w[i].toString());
					System.out.println("Net Salary: " + w[i].computeNetSal());
					}
					break;
			
			case 4: exit=false;
					break;
			}
			
		}
		
		sc.close();
	}

}
