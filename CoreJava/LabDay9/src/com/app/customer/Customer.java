package com.app.customer;

public class Customer {
	
	private String email;
	private String password;
	private String name;
	private double regAmt;
	private String city;

	public Customer(String mail , String pw , String nm , double amt , String city) 
	{
		email = mail;
		password = pw;
		name = nm;
		regAmt = amt ; 
		this.city = city;
	}
	
	public String toString()
	{
		return "Email: " + email + " Name: " + name + " Registration amount: " + regAmt + " City: " + city;
	}
	
	
	@Override 
	public boolean equals(Object o)
	{
		if (o instanceof Customer) 
		{
			return email.equals(((Customer) o).email);
		}
			return false;
	}

	public String getCity() {
		return city;
	}
	
	

}
