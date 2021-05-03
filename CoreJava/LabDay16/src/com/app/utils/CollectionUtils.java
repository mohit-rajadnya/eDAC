package com.app.utils;

import java.util.ArrayList;
import static java.time.LocalDate.*;
import com.app.customer.Customer;
import static com.app.customer.CustomerType.*;

public class CollectionUtils {

	public static ArrayList<Customer> CustomerList()
	{
		ArrayList<Customer> customers = new ArrayList<>();
		
		customers.add(new Customer("mohit@gmail.com", "mohit@123", "Mohit", 2000 , parse("1996-12-01"), "Kolhapur", GOLD));
		customers.add(new Customer("walter@gmail.com", "walter@123" , "Walter" , 500 , parse("1990-12-04"), "Pune", PLATINUM));
		customers.add(new Customer("anna@gmail.com", "anna@123", "Anna", 7000 , parse("2019-03-01"), "Mumbai", GOLD));
		customers.add(new Customer("shivam@gmail.com", "shivam@123" , "Shivam" , 500 , parse("1997-07-01"), "Nagpur", PLATINUM));
		customers.add(new Customer("mohit@gmail.com", "mohit@123", "Mohit", 2000 , parse("1999-10-30"), "Goa", SILVER));
		customers.add(new Customer("advay@gmail.com", "advay@123" , "Advay" , 3000 , parse("2020-12-23"), "Pune", PLATINUM));
		
		return customers;
	}
}
