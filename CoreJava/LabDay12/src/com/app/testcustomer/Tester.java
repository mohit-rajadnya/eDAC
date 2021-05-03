package com.app.testcustomer;

import java.util.Date;
import java.util.Scanner;
import static com.app.utils.CustomValidations.*;
import static com.app.customer.CustomerType.*;

import com.app.customer.Customer;
import com.app.customer.CustomerType;

import custom_exception.CustomException;

public class Tester {


	public static void main(String[] args) {
		
				
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many customers you want to add");
		Customer[] c = new Customer[sc.nextInt()];
		
		int counter = 0;
		boolean exit = true;
		
		while(exit)
		{
			try
			{
			System.out.println(" 1.Add customer \n 2.Display All customers from a city \n 3.Change phone number \n 4. Exit \n Enter your choice");
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
					
					System.out.println("Enter your City");
					String city = sc.next();
					
					System.out.println("Enter your Customer type");
					CustomerType type = valueOf(sc.next().toUpperCase()) ;					
					
					Customer c1 = new Customer(id , pw , nm , amt , city , d , type);	
					System.out.println("Customer registered!!!");
										
					c[counter++] = c1;
					
					System.out.println("Enter Address details \n 1.State \n 2.Country \n 3.PhoneNumber");
					c1.linkAddress(sc.next(), sc.next(), sc.next());
					System.out.println("Address added succesfully");
					break;
					
					
			case 2: System.out.println("Enter city from which customers you want to view");
					city = sc.next();
					
					for(Customer temp: c)
					{
						if(temp!=null)
							{
								if(temp.getCity().equals(city))
								{
									System.out.println(temp.toString());
								}	
									
							}
						
					}					
					break;
			
			case 3: System.out.println("Enter emailId , DateOf Birth , password and new phone number");
					
					String mail = sc.next();
					Date d2 = sdf.parse(sc.next());
					String password = sc.next();
					String ph = sc.next();
					for (Customer c2 : c)
					{
						if(c2.getEmail().equals(mail) && c2.getDOB().equals(d2) && c2.getPassword().equals(password))
							{
								c2.setPhone(ph);
								System.out.println("Successfully Changed");
							}
						else
							{
								throw new CustomException("Invalid details");
							}
					}
						
					break;
			
			case 4: exit = false;
					break;
					
			
					
			}
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			sc.nextLine();
			continue;

		
			
		}
	}
	sc.close();
	}
	
}
