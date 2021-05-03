package com.app.utils;

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
	
	public static void validateDuplicateEmail(Customer[] customers , String email) throws CustomException
	{
			Customer temp = new Customer(email);
			
			for(Customer c : customers)
				{
					if(c!=null)
						{
							if(c.equals(temp))
							
							{
								System.out.println("Customer exists!! Please check your email ID!");
								break;
							}
						}
				}	
			
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
}

























