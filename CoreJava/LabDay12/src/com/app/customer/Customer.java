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
	private Address address;

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
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Date getDOB() {
		return DOB;
	}

	public Customer(String mail , Date dob)
	{
		email = mail;
		this.DOB = dob;
	}
	
	@Override
	public String toString()
	{
		return "Email: " + email + " Name: " + name + " Registration amount: " + regAmt + " City: " + city + " Date Of Birth: " + sdf.format(DOB) + " Customer Type: " + type + 
				" State: " + address.State + " Country: " + address.Country + " PhoneNumber: " + address.phone ;
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
	
	private class Address
	{
		private String city;
		private String State;
		private String Country;
		private String phone;
		
		public Address( String s , String count , String ph)
		{
			this.city = Customer.this.city;
			State = s;
			Country = count;
			phone = ph;
		}
		
		
		
	}
	
	public void linkAddress( String s , String country , String ph)
	{
		address = new Address( s , country , ph);
	}
	
	public void setPhone(String ph)
	{
		address.phone = ph;
	}

}
