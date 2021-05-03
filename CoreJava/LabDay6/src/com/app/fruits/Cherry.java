package com.app.fruits;

public class Cherry extends Fruits{

	public Cherry(String nm) {
		super(nm);
	}

	
	@Override
	public void taste()
	{
		System.out.println( super.getName() + "is Sweet in taste");
	}
}

