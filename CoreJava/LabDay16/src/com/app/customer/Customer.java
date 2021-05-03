package com.app.customer;

import java.time.LocalDate;
import java.util.Comparator;

public class Customer implements Comparable<Customer> {
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	private String email;
	public double getRegAmt() {
		return regAmt;
	}

	@SuppressWarnings("unused")
	private String password;
	private String name;
	private double regAmt;
	private LocalDate DOB;
	private Address address;
	private String city;
	private CustomerType type;

	public Customer(String mail , String pw , String nm , double amt , LocalDate d , String city , CustomerType type) 
	{
		email = mail;
		password = pw;
		name = nm;
		regAmt = amt ; 
		DOB = d;
		this.city = city;
		this.type = type;
	}
	
	public Customer(String mail , LocalDate dob)
	{
		email = mail;
		this.DOB = dob;
	}
	
//	public String toString()
//	{
//		return "Email: " + email + " Name: " + name + " Registration amount: " + regAmt + " Date Of Birth: " + DOB + " City: " + city + " Date Of Birth: " + DOB + " Customer Type: " + type + 
//				" State: " + address.State + " Country: " + address.Country + " PhoneNumber: " + address.phone ;
//	}
	
	@Override
	public String toString()
	{
		return "Email: " + email + " Name: " + name + " Registration amount: " + regAmt + " Date Of Birth: " + DOB + " City: " + city + " Date Of Birth: " + DOB + " Customer Type: " + type ;
	}
	
	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public String getCity() {
		return city;
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

	private class Address
	{
		
		private String State;
		private String Country;
		private String phone;
		
		public Address( String s , String count , String ph)
		{
			
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
	
	@Override
	public int compareTo(Customer o)
	{
		
		
		if(this.email.equals(o.email))
		{
			return this.DOB.compareTo(o.DOB);
		}
		return this.email.compareTo(o.email);
	}
	

}
