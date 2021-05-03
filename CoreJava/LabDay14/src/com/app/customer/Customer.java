package com.app.customer;

import java.util.Date;

public class Customer {
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Date getDOB() {
		return DOB;
	}

	private String email;
	@SuppressWarnings("unused")
	private String password;
	private String name;
	private double regAmt;
	private Date DOB;

	public Customer(String mail , String pw , String nm , double amt , Date d) 
	{
		email = mail;
		password = pw;
		name = nm;
		regAmt = amt ; 
		DOB = d;
	}
	
	public Customer(String mail , Date dob)
	{
		email = mail;
		this.DOB = dob;
	}
	
	public String toString()
	{
		return "Email: " + email + " Name: " + name + " Registration amount: " + regAmt + " Date Of Birth: " + DOB;
	}
	
	@Override 
	public boolean equals(Object o)
	{
		if (o instanceof Customer) 
		{
			return email.equals(((Customer) o).email) && DOB.equals(((Customer) o).DOB);
		}
			return false;
	}

	
	

}
