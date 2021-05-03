package com.app.utils;

import static java.time.LocalDate.parse;
import static com.app.core.CourseName.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.app.core.Student;

public class MapUtils {
	
	
	public static List<Student> stdList()
	{
		return Arrays.asList(new Student(100, SPRING , "Mohit" , 100, parse("1996-12-01")),
		new Student(101, SPRING_BOOT, "Chloe" , 120, parse("1996-12-01")),
		new Student(102, DBT, "Walter" , 120, parse("1984-12-01")),
		new Student(100, SPRING, "Baburao" , 120, parse("1999-10-30")),
		new Student(102, DBT, "Walter" , 130, parse("1984-12-01")),
		new Student(103, SPRING, "Baburao" , 130, parse("1999-10-30")),
		new Student(104, DBT, "Walter" , 100, parse("1984-12-01")),
		new Student(105, SPRING, "Baburao" , 100, parse("1999-10-30")));
		
	}
	
	public static HashMap<Integer, Student> stdMap()
	{
		List<Student> list = stdList();
		
		HashMap<Integer, Student> stdMap = new HashMap<>();
		
		for (Student l : list)
			stdMap.put(l.getPRN(), l);
		
		return stdMap;
	}
		
	
	
	
	
}
