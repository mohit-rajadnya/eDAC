package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.app.customer.Customer;

import custom_exception.CustomException;

public class CustomValidations {
	
	public static void validateEmail(String email) throws CustomException
	{
		if (email.length()<8 | email.length()>20)
			{
				throw new CustomException("Email ID should have letters between 8-20 range!");	
			}
		
		if(!(email.contains("@")))
		{
			throw new CustomException("Email ID should contain '@' symbol !");
		}
		
		if(!(email.endsWith(".com")))
			throw new CustomException("Email should end with '.com'! ");
	}
	
	public static void validateDuplicate(ArrayList<Customer> customers , String email , Date d) throws CustomException
	{
						
				
					if(customers.contains(new Customer(email , d)))
						throw new CustomException("Customer already exist!!!");
					
				
			
	}
			
	public static Customer validateIfExists(ArrayList<Customer> customers , String email , Date d) throws CustomException
	{
			Customer temp = new Customer(email , d);
			Integer index= customers.indexOf(temp);
			
			if(index!= -1)
			{
				temp = customers.get(index);
				return temp;
			}
			else
				throw new CustomException("Customer does not exist!!!");
//			for(Customer c : customers)
//				{
//					if(c!=null)
//						{
//							if(c.equals(temp))
//							
//							{
//								return c;
//							}
//						}
//				}
//			throw new CustomException("Customer not found!!");
		
		
			
	}
	
	
	public static void validatePassword(String pw) throws CustomException
	{
		if(!(pw.matches("((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})")))
			throw new CustomException("Password should be alphanumeric and contain atleast one special character!");
	}
	
	public static void validateRegAmt(double val) throws CustomException
	{
		if(val%500!=0)
			throw new CustomException("Registration amount needs to be in multiples of 500!");
	}

	public static void validateDOB(Date d) throws CustomException , ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Date d1 = sdf.parse("2020/01/01");
		if(d.after(d1))
		{
			throw new CustomException("Date of birth needs to be before 1st of Jan 2020");
		}
	}
	
	public static void validateForLogin(ArrayList<Customer> customers , String email , Date d , String p) throws CustomException
	{
		boolean flag = false;
		for(Customer c : customers)
		{
			if(c.getEmail().equals(email) && c.getDOB().equals(d) && c.getPassword().equals(p))
			{
				System.out.println("Successfully logged in!!");
				flag = true;
				break;
			}
		}
		if(!flag)
		{
			throw new CustomException("Customer not found!!");
		}
	}
	
	public static void customerRemove(ArrayList<Customer> customers , String email , Date d) throws CustomException
	{
			Customer temp = new Customer(email , d);
			
			/*
			 * for(Customer c : customers) { if(c!=null) { if(c.equals(temp))
			 * 
			 * { return c; } } }
			 */
			int index = customers.indexOf(temp); 
			if(index != -1)
			{	temp=customers.get(index);
				System.out.println("Removed Customer is : \n "+temp);
				customers.remove(index);
				
			}
			else
			throw new CustomException("Customer not found!!");
			
	}
}

























