package com.app.tester;

import java.util.HashSet;
import java.util.TreeSet;

import static java.time.LocalDate.*;
import com.app.core.Student;

public class TestStudent {

	public static void main(String[] args) {
		
		HashSet<Student> students = new HashSet<>();
		
		System.out.println(students.add(new Student(100, "Core Java", "Mohit" , 100, parse("1996-12-01"))));
		System.out.println(students.add(new Student(101, "Adv Java", "Chloe" , 100, parse("1997-12-01"))));
		System.out.println(students.add(new Student(102, "Database", "Walter" , 78, parse("1984-12-01"))));
		System.out.println(students.add(new Student(100, "Core Java", "Baburao" , 120, parse("1999-10-30"))));
		
		for(Student s1 : students)
			System.out.println(s1);
		
		TreeSet<Student> s = new TreeSet<>(students);
		
		
		System.out.println(students.size());
		System.out.println("Student details: ");
		for(Student s1 : s)
			System.out.println(s1);
	}

}
