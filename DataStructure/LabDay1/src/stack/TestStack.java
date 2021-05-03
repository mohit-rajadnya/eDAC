package stack;

import java.util.Scanner;

public class TestStack {

	public static void main(String[] args) {


		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter size of stack!");
			
			StackClass myStack = new StackClass(sc.nextInt());
			
			System.out.println(myStack.isFull());
			System.out.println(myStack.isEmpty());
			
			myStack.push(10);
			myStack.push(5);
			myStack.push(8);
			
			System.out.println(myStack.isFull());
			
			myStack.push(2);
			myStack.push(8);
			
			System.out.println(myStack.isFull());
			
			System.out.println("Element removed: " + myStack.pop());
			System.out.println("Element removed: " + myStack.pop());
			System.out.println("Element removed: " + myStack.pop());
			
			System.out.println(myStack.isEmpty());
			
			System.out.println("Element removed: " + myStack.pop());
			System.out.println("Element removed: " + myStack.pop());
			
			System.out.println(myStack.isEmpty());
			
			
		}

	}

}
