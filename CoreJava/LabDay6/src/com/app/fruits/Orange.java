package com.app.fruits;

public class Orange extends Fruits{

	public Orange(String nm) {
		super(nm);
	}

	
	@Override
	public void taste()
	{
		System.out.println( super.getName() + "is Sweet n Sour in taste");
	}
}

