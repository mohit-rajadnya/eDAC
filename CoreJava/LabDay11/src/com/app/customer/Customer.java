package com.app.customer;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	
	public static SimpleDateFormat sdf; 
	static
	{
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	private String email;
	@SuppressWarnings("unused")
	private String password;
	private String name;
	private double regAmt;
	private String city;
	private Date DOB;
	private CustomerType type;
	
	public Customer(String mail , String pw , String nm , double amt , String city , Date d , CustomerType type) 
	{
		email = mail;
		password = pw;
		name = nm;
		regAmt = amt ; 
		this.city = city;
		DOB = d;
		this.type = type;
	}
	
	public Customer(String mail , Date dob)
	{
		email = mail;
		this.DOB = dob;
	}
	
	@Override
	public String toString()
	{
		return "Email: " + email + " Name: " + name + " Registration amount: " + regAmt + " City: " + city + " Date Of Birth: " + sdf.format(DOB) + " Customer Type: " + type;
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

	public String getCity() {
		return city;
	}
	
	
	

}
