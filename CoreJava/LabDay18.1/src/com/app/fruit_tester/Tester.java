package com.app.fruit_tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.app.fruits.Fruits;
import com.app.fruits.Melon;

public class Tester {
	
	public static void main(String args[])
	{
		//List<? extends Fruits> fruits=new Vector<Object>();
		List<? super Melon> melons=new ArrayList<Fruits>();
	}

}
