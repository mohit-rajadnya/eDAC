package queue;


import java.util.Scanner;

public class TestCircularQueue {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter length of the queue");
		CircularQueueClass q = new CircularQueueClass(sc.nextInt());
		boolean exit = false;
		
		
		while(!exit)
		{
		System.out.println("1.Add member to queue \n 2.Remove member from queue \n 3.Display queue");
		
		int choice = sc.nextInt();
		
		
		
				switch (choice)
				
				{
					case 1: System.out.println("Enter element to add");
							q.enqueue(sc.nextInt());
							break;
						
					case 2: System.out.println("Removed element : " + q.dequeue());
							break;
					case 3: q.displayQueue();
							exit = true;
							break;
			}
			}

		sc.close();
	}
		
}
