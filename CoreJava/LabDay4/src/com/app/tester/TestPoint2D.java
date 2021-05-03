package com.app.tester;

import java.util.Scanner;

import com.app.geometry.Point2D;

public class TestPoint2D {
	
	public static void main(String [] args)
	{
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter how many points you want");
	
	Point2D[] points = new Point2D[sc.nextInt()];
	boolean exit = false;
	int counter = 0;
	
	while(!exit)
	{
		System.out.println("1. Add new point \n 2.Display all points \n 3.Calculate distance between 2 points \n 4. Exit");
		System.out.println("Choose your option");
		
		switch(sc.nextInt())
		{
		case 1: if (counter < points.length)
			{
				System.out.println("Enter position at which you want your coordinate and its x and y position ");
				int index = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				points[index] = new Point2D(x,y);
				counter++;
				break;
			}
			else
			{
				System.out.println("Array length exceeded");
				break;
			}
		case 2 :for(Point2D p : points)//points[0] = p ; points[1] = p
				     if(p != null)
				     System.out.println(p.getDetails());
				break; 
				
		case 3 : System.out.println("Enter indexes of points to get distance between them");
				 int x = sc.nextInt();
				 int y = sc.nextInt();
				 
				 double dist = points[x].calcDistance(points[y]);
				 System.out.println("Distance between the points is =  " + dist);
				 break;
				 
		case 4: exit = true;
				break;
				 
		
		}
	}
	
	sc.close();
	
	}
}
