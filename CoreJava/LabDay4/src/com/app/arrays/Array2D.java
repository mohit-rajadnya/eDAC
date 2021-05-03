package com.app.arrays;

import java.util.Arrays;

public class Array2D {
	
	public static void main(String args[])
	{
		double[][] d = new double[2][50];
		
		int counter = 100;
		
		for(int i=0;i<d.length;i++)
		{
			for(int j = 0 ; j<d[i].length ; j++)
			{
				d[i][j] = counter;
				counter++;
			} System.out.println();
			
		}
		System.out.println();
		
		for(int i =0 ; i<d.length;i++)
		{
			for(int j = 0 ; j<d[i].length ; j++)
			{
				System.out.print(d[i][j]);
			}System.out.println();
		}System.out.println();
		
		for(double[] i : d)
		{
			for(double j : i)
			{
				System.out.print(j);
			} System.out.println();
		}
	
		System.out.println();
		System.out.println(Arrays.deepToString(d));
	}

}
