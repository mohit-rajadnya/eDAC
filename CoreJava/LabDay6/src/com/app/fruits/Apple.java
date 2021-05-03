package com.app.fruits;

public class Apple extends Fruits{

	public Apple(String nm)
	{
		super(nm);
	}

	@Override
	public void taste()
	{
		System.out.println( getName() + " is Sweet in taste");
	}
}
