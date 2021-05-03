package com.app.utils;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.customer.Customer;
import custom_exception.CustomException;

public class CustomValidations {
	
	public static SimpleDateFormat sdf;
	public static Date validJoinDate;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			validJoinDate = sdf.parse("31-12-2020");
		} catch (ParseException e) {
			System.out.println("err in static init block " + e);
		}
	}
	
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
	
	public static void validateDuplicate(Customer[] customers , String email , Date d) throws CustomException
	{
			Customer temp = new Customer(email , d);
			
			for(Customer c : customers)
				{
					if(c!=null)
						{
							if(c.equals(temp))
							
							{
								System.out.println("Customer exists!! Please check your email ID and BirthDate!");
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

	public static void validateDOB(Date d) throws CustomException , ParseException
	{
		
		if(d.after(validJoinDate))
		{
			throw new CustomException("Date of birth needs to be before 1st of Jan 2020");
		}
	}
	
	public static void validateCountry(String c)throws CustomException
	{
		if(!(c.equals("India")))
		{
			throw new CustomException("Current we only register Indian customers!!");
		}
	}
}

























