package com.app.fruits;

public class Fruits {
	
	private String name;
	
	public Fruits(String nm)
	{
		name = nm;
	}
	
	public void taste()
	{
		System.out.println("No specific taste");
	}
	
	public String getName()
	{
		return name;
	}
}
