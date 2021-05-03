package threads_assignment3;
import static java.lang.Thread.currentThread;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println(currentThread().getName());
		
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("enter range for even number thread: ");
			RunnableTaskEven task1 = new RunnableTaskEven(sc.nextInt(), sc.nextInt());
			System.out.println("enter range for odd number thread: ");
			RunnableTaskOdd task2 = new RunnableTaskOdd(sc.nextInt(), sc.nextInt());
			
			Thread t1 = new Thread(task1 , "one");
			Thread t2 = new Thread(task2 , "two");
			t2.start();
			t1.start();
			for (int i=0 ; i<30 ; i++)
			{
				System.out.println("Inside " + currentThread().getName() + " " + i);
				Thread.sleep(200);
			}
			
			System.out.println("Main waiting for child threads to complete!");
			t1.join();t2.join();
			System.out.println("Child thread over");
			
			System.out.println("Main over");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
