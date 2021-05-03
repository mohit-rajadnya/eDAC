package com.app.testcustomer;


import static java.time.LocalDate.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;
import static com.app.customer.CustomerType.valueOf;
import static com.app.utils.CustomValidations.*;

import com.app.custom_comparator.RegAmtComparator;
import com.app.customer.Customer;
import com.app.customer.CustomerType;
import static com.app.utils.CollectionUtils.*
;
public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);	
			
		ArrayList<Customer> customers = CustomerList();
		
		
		boolean exit = true;
		
		while(exit)
		{
			try
			{
				
			System.out.println(" 1.Add customer \n 2.Fetch details \n 3.Customer login \n 4.Unsubscribe \n 5.Get customer with constraints"
					+ " \n 6.Change phone number \n 7.Sort using natural sort \n 8.Sort using external class \n 9.Sort using anonymous class \n"
					+ " 10.Exit \n Enter your choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter email id");
					String id = sc.next();
					validateEmail(id);
					
					System.out.println("Enter Date of Birth in format yyyy-MM-dd");
					
					LocalDate d = parse(sc.next());
					validateDuplicate(customers, id , d);
					validateDOB(d);
					
					
					System.out.println("Enter password");
					String pw = sc.next();
					validatePassword(pw);
					
					System.out.println("Enter name");
					String nm = sc.next();
					
					System.out.println("Enter registration amount");
					double amt = sc.nextDouble();
					validateRegAmt(amt);
					
					System.out.println("Enter your city");
					String city = sc.next();
					
					System.out.println("Enter your Customer type");
					CustomerType type = valueOf(sc.next().toUpperCase()) ;	
					
					Customer c1 = new Customer(id , pw , nm , amt , d , city ,type );		
										
					customers.add(c1);
					break;
					
					
			case 2: System.out.println("Enter email and DOB");
					
					System.out.println("Customer details: \n" + validateIfExists(customers, sc.next(), parse(sc.next())));
					break;
					
			case 3: System.out.println("Enter \n 1.EmailID \n 2.DateOfBirth \n 3.Password ");
					validateForLogin(customers, sc.next(),parse(sc.next()), sc.next());
					break;
					
			case 4: System.out.println("Enter email and DOB to unsubscribe customer");
					customerRemove(customers,sc.next(), parse(sc.next()));
					break;
					
			case 5: System.out.println("Enter a range of Dates (yyyy-MM-dd) and minimum registration amount");
					fetchSpecificCustomer(customers, parse(sc.next()), parse(sc.next()), sc.nextInt());
					break;
					
			case 6: System.out.println("Enter emailId , DateOf Birth , password and new phone number");
					changePhoneNumber(customers, sc.next(), parse(sc.next()), sc.next(), sc.next());
					break;
					
			case 7: Collections.sort(customers);
					ListIterator<Customer> itr = customers.listIterator();
					while(itr.hasNext())
					{
						System.out.println(itr.next());
					}
					break;
			
			case 8: Collections.sort(customers , new RegAmtComparator()); 
					itr = customers.listIterator();
					while(itr.hasNext())
					{
						System.out.println(itr.next());
					}
					break;
					
			case 9: Collections.sort(customers , new Comparator<Customer>() {
				@Override
					public int compare(Customer c1 , Customer c2) {
						
						if(c1.getRegAmt() > c2.getRegAmt())
							return 1;
						if(c1.getRegAmt() < c2.getRegAmt())
							return -1;
						return c1.getCity().compareTo(c2.getCity());
							
						}
					});
					
					itr = customers.listIterator();
					while(itr.hasNext())
					{
						System.out.println(itr.next());
					}
					break;
					
			case 10: exit = false;
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
