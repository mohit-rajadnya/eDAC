package com.app.utils;

import com.app.fruits.Fruits;

public class FruitUtils {

	public static void addFruit(Fruits f , Fruits[] basket , int counter) {
		
		
		basket[counter] = f;
		//incrementing this counter will not work as it is a copy of counter inside testfruit

	}

}


