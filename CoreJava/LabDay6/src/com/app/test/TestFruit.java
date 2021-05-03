package com.app.test;

import java.util.Scanner;

import com.app.fruits.Apple;
import com.app.fruits.Cherry;
import com.app.fruits.Fruits;
import com.app.fruits.Orange;

import static com.app.utils.FruitUtils.addFruit;

public class TestFruit {

	static int counter = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter how many fruits you want");
		Fruits[] basket = new Fruits[sc.nextInt()];
		
		
		boolean exit = true;
		
		while(exit)
		{
			System.out.println("1. Add an apple \n2. Add an Orange \n3.Add a cherry \n4.Display all fruits \n5.Exit");
			int choice = sc.nextInt();
			
			
			
			switch(choice)
			{
			
			case 1: 
				if(counter<basket.length)
				{
					System.out.println("Enter a variety of Apple");
					addFruit(new Apple(sc.next()), basket , counter);
					counter++;
					break;
				}
				else
					System.out.println("Basket overloaded");
					break;
					
			case 2:if(counter<basket.length)
					{
						System.out.println("Enter a variety of Orange");
						addFruit(new Orange(sc.next()), basket , counter);
						counter++;
						break;
					}
					else
						System.out.println("Basket overloaded");
						break;
			
			case 3: if(counter<basket.length)
					{
						System.out.println("Enter a variety of Cherry");
						addFruit(new Cherry(sc.next()), basket , counter);
						counter++;
						break;
					}
					else
						System.out.println("Basket overloaded");
						break;
					
			case 4:for (Fruits f: basket )
						{
							if(f!=null)
							f.taste();
						}
						break;
			
			case 5: 
			
			case 6: exit = false;
					break;
			
			}
		}
		
		sc.close();
	}

}
