package lab_assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static java.time.LocalDate.*;

public class Requirement4_2 {
	
	
	public static void main(String args[])
	{
	try(Scanner sc = new Scanner(System.in))
	{
		ArrayList<LocalDate> Dates = new ArrayList<>();
		boolean exit = true;
		
		while(exit)
		{
			System.out.println(" 1. Enter date \n 2. Display all dates in ascending order \n 3. Quit \n Choose your option");
			int option = sc.nextInt();
			
			switch(option)
			{
			case 1: System.out.println("Enter a date to add (yyyy-MM-dd)");
					Dates.add(parse(sc.next()));
					System.out.println("Successfully added");
					break;
			
			case 2: Collections.sort(Dates);
					System.out.println(Dates);
					break;
			case 3: exit = false;
					break;
			}
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
}


//try (Scanner sc = new Scanner(System.in)) {
//	String input = null;
//	ArrayList<LocalDate> dates = new ArrayList<>();
//	while (true) {
//		System.out.println("Enter date or type quit to exit");
//		input=sc.next();
//		if (input.equalsIgnoreCase("quit"))
//			break;
//		dates.add(LocalDate.parse(input));
//	}
//	System.out.println("Orig dates " + dates);
//	// sorting : based upon Comparable
//	Collections.sort(dates);
//	for (LocalDate d : dates)
//		System.out.println(d);
//} catch (Exception e) {
//	e.printStackTrace();
//}

