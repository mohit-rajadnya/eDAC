package com.app.tester;

import java.util.Scanner;

import com.app.core.StackClass;

public class TestStack {

	
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
		boolean flag = false;
		System.out.println("Enter size of stack");
		StackClass stack = new StackClass(sc.nextInt());
		try
		{
		while(!flag)
		{
			System.out.println(" 1.Add an element in stack /n 2.Check top element in stack /n 3.Remove element from stack /n "
					+ "/n 4.Exit /n Pick your choice");
			switch(sc.nextInt())
			{
			case 1:System.out.println("Enter element to push into stack");
					stack.push(sc.nextInt());
					break;
					
			case 2:System.out.println("Element at the top of stack is: " + stack.top());
					break;
			
			case 3:System.out.println("Element removed from stack is: " + stack.pop());
					break;
			
			case 4:flag=true;
					break;
			}
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
		
	}

}
