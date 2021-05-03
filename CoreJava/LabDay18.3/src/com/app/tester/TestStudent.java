package com.app.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import static com.app.utils.MapUtils.*;
import static java.time.LocalDate.*;

import com.app.core.CourseName;
import com.app.core.Student;
import static com.app.core.CourseName.*;
import static com.app.utils.StudentValidations.*;
public class TestStudent {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			HashMap<Integer, Student> stdMap = stdMap();
			boolean exit = false;
			
			while(!exit)
			{
				try 
				{
					System.out.println(" 1. Student Addmission \n 2. Fetch Student details \n 3. Display all students"
							+ " \n 4. Update marks of a student \n 5. Cancel Addmission \n 6. Display students with certain course"
							+ " \n 10. Exit ");
					
					switch(sc.nextInt())
					{
					case 1: System.out.println("Enter student details");
							System.out.println("1. PRN");
							int prn = sc.nextInt();
							validateStudent(stdMap, prn);
							
							System.out.println("2. Course name , 3. Name , 4. Marks , 5. Date of Birth(yyyy-MM-dd)");
							stdMap.put(prn, new Student(prn, valueOf(sc.next().toUpperCase()), sc.next(), sc.nextInt(), parse(sc.next())));
							break;
							
					case 2: System.out.println("Enter PRN");
					
							prn = sc.nextInt();
							Student temp = checkIfExist(stdMap, prn);
							
							System.out.println("Student details: " + temp);
							break;
							
					case 3: System.out.println("Details of all students:");
					
					
							for(Student s : stdMap.values())
								System.out.println(s);
							break;
							
					case 4: System.out.println("Enter PRN and new marks of student");
					
							prn = sc.nextInt();
							temp = checkIfExist(stdMap, prn);
							
							temp.setMarks(sc.nextInt());
							break;
					
					case 5: System.out.println("Enter PRN of the Student");
					
							prn = sc.nextInt();
							temp = checkIfExist(stdMap, prn);
							System.out.println("Admission withdrawn of: " + stdMap.remove(prn));
							break;
							
					case 6: System.out.println("Enter course name of which Students list required");
					
							CourseName nm = valueOf(sc.next().toUpperCase());
							validateCourseName(nm);
							
							for(Student s : stdMap.values())
								if(s.getCourse().equals(nm))
									System.out.println(s);
							break;
							
					case 7: ArrayList<Student> stdArr = new ArrayList<>(stdMap.values());
							Collections.sort(stdArr, new Comparator<Student>() {
								
								public int compare(Student s1 , Student s2)
								{
									int ret = (s1.getCourse().compareTo(s2.getCourse()));
									if(ret == 0 )
										return ((Integer)s1.getMarks()).compareTo(s2.getMarks());
									return ret;
								}
							});
							
							System.out.println("Students details: ");
							for (Student s : stdArr)
								System.out.println(s);
							
							
					case 10: exit = true;
							break;
							
					default: System.out.println("Invalid input!!");
							break;
							
					
							
					}
					
					
				}catch (Exception e) {
					e.getMessage();
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}		

	}

}


