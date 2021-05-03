package testemp;
import java.util.Scanner;

import emp.Employees;
import emp.FixedStack;
import emp.GrowableStack;
import emp.Stack;

public class EmpTester {
	
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		boolean exit = true;
		Stack ref = null;
		
		while(exit)
		{
			System.out.println(" 1. Create a Fixed Stack \n 2. Create a Growable Stack \n 3. Push \n 4. Pop \n 5. Display Employees \n 6. Exit   ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: if(ref==null)
						{
							ref = new FixedStack();
							break;
						}
						else
						{
							System.out.println("Stack already haas been chosen. Please go ahead with it");
							break;
							
						}
				case 2: if(ref==null)
						{
							ref = new GrowableStack();
							break;
						}
						else
						{
							System.out.println("Stack already haas been chosen. Please go ahead with it");
							break;
							
						}
				case 3: if(ref == null)
						{
							System.out.println("Stack not been chosen yet. Please select one of the above stacks");
							break;
						}
						else
						{
							System.out.println("Enter employee details 1.ID \n 2.Name \n 3.Salary");
							Employees p = new Employees(sc.nextInt() , sc.next() , sc.nextDouble());
							
							ref.push(p);
							break;
														
						}
				
				case 4: System.out.println("Removed element: " + ref.pop());
						break;
						
//				case 5: if (ref instanceof FixedStack) 
//						{
//							for(Employees temp : ((FixedStack) ref).getE())
//								if(temp!=null)
//							System.out.println(temp);
//							break;
//						}
//						if (ref instanceof GrowableStack) 
//						{
//							for(Employees temp : ((GrowableStack) ref).getE())
//								if(temp!=null)
//							System.out.println(temp);
//							break;
//						}
				case 5:
						for(Employees temp: ref.getE())
							{
								if(temp!=null)
									System.out.println(temp);
							}
						break;
						
								
				
				case 6: exit = false;
						break;
			}
		}
		sc.close();

	}

}
