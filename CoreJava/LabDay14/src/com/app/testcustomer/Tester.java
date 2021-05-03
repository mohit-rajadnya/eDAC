    package com.app.testcustomer;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static com.app.utils.CustomValidations.*;

import com.app.customer.Customer;

public class Tester {
	
	public static SimpleDateFormat sdf; 
	static
	{
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);	
				
		ArrayList<Customer> c = new ArrayList<>();
		
		
		boolean exit = true;
		
		while(exit)
		{
			try
			{
				
			System.out.println(" 1.Add customer \n 2.Fetch details \n 3.Customer login \n 4.Unsubscribe \n 5.Exit \n Enter your choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter email id");
					String id = sc.next();
					validateEmail(id);
					
					System.out.println("Enter Date of Birth in format yyyy-MM-dd");
					String dob = sc.next();
					Date d = sdf.parse(dob);
					validateDuplicate(c, id , d);
					validateDOB(d);
					
					
					System.out.println("Enter password");
					String pw = sc.next();
					validatePassword(pw);
					
					System.out.println("Enter name");
					String nm = sc.next();
					
					System.out.println("Enter registration amount");
					double amt = sc.nextDouble();
					validateRegAmt(amt);
					
					Customer c1 = new Customer(id , pw , nm , amt , d);		
										
					c.add(c1);
					break;
					
					
			case 2: System.out.println("Enter email and DOB");
					
					System.out.println("Customer details: \n" + validateIfExists(c, sc.next(), sdf.parse(sc.next())));
					break;
					
			case 3: System.out.println("Enter \n 1.EmailID \n 2.DateOfBirth \n 3.Password ");
					validateForLogin(c, sc.next(), sdf.parse(sc.next()), sc.next());
					break;
					
			case 4: System.out.println("Enter email and DOB to unsubscribe customer");
					customerRemove(c,sc.next(), sdf.parse(sc.next()));
					break;
			
			case 5: exit = false;
					break;
					
			
					
			}
		}catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			sc.nextLine();
			continue;

		
			
		}
	}sc.close();
	
	}
	
}
