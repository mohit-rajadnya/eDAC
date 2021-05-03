package com.app.testcustomer;

import java.util.Scanner;
import static com.app.utils.CustomValidations.*;

import com.app.customer.Customer;

public class Tester {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
		
		System.out.println("Enter how many customers you want to add");
		Customer[] c = new Customer[sc.nextInt()];
		
		int counter = 0;
		boolean exit = true;
		
		while(exit)
		{
			System.out.println(" 1.Add customer \n 2.Display All customers from a city \n 3.Exit \n Enter your choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter email id");
					String id = sc.next();
					validateEmail(id);
					validateDuplicateEmail(c, id);
					
					
					System.out.println("Enter password");
					String pw = sc.next();
					validatePassword(pw);
					
					System.out.println("Enter name");
					String nm = sc.next();
					
					System.out.println("Enter registration amount");
					double amt = sc.nextDouble();
					validateRegAmt(amt);
					
					System.out.println("City");
					String city = sc.next();
					
					Customer c1 = new Customer(id , pw , nm , amt , city);		
										
					c[counter++] = c1;
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
					
			case 3: exit = false;
					break;
					
			
					
			}
		}

		}catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}
