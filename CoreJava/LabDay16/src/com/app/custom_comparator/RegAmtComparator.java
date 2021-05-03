package com.app.custom_comparator;

import java.util.Comparator;

import com.app.customer.Customer;

public class RegAmtComparator implements Comparator<Customer>{
	
	public int compare(Customer c1 , Customer c2)
	{
		
		return ((Double)c1.getRegAmt()).compareTo(c2.getRegAmt());
	}

}
