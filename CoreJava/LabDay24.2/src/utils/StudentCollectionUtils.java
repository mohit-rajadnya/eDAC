package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.LocalDate.*;
import static com.app.core.Subject.*;

import com.app.core.Address;
import com.app.core.Student;

public class StudentCollectionUtils {
	private static int index=0;
	public static List<Student> populateList() {
		 List<Student> students = Arrays.asList(
				new Student("dbda-001", "ravi",parse("1990-12-13"), DBT, 7),
				new Student("dbda-009", "riya",parse("1992-12-13"), ML, 6.9),
				new Student("dbda-004", "shekhar",parse("1991-12-13"), DBT, 8.9),
				new Student("dbda-002", "priya",parse("1990-02-23"), JAVA, 4),
				new Student("dbda-007", "kiran",parse("1993-02-13"), R, 4.1),
				new Student("dbda-003", "meeta",parse("1993-12-13"), R, 5.9),
				new Student("dbda-008", "sameer",parse("1991-12-06"), DBT, 5)
				);
		 List<Address> adrs=Arrays.asList(new Address("pune", "MH", "452446"),
				 new Address("pune", "MH", "652446"),
				 new Address("nagpur", "MH", "852446"),
				 new Address("indore", "MP", "752446"),
				 new Address("mumbai", "MH", "672446"),
				 new Address("pune", "MH", "692446"),
				 new Address("chennai", "TN", "862446"));
		 
		 students.forEach(s->s.assignAddress(adrs.get(index++)));
		 return students;//method returns populated list of students , linked with address
	}
	
	public static Map<String, Student> map()
	{
		List<Student> list = populateList();
		HashMap<String, Student> stdMap = new HashMap<>();
				
		list.forEach(s -> stdMap.put(s.getRollNo(),s));
		return stdMap;
				
	}
	
	public static List<Student> sortUsingGpa(Map<String, Student> map)
	{
		//sorting as per value  , hence convert it to a collection --> list --> collections.sort
		//function literal: for comparator
		Comparator<Student> gpaComp = (s1,s2)-> ((Double)s1.getGpa()).compareTo(s2.getGpa());
		ArrayList<Student> list = new ArrayList<>(map.values());
		Collections.sort(list, gpaComp);
		return list;	
		
	}
	
	public static List<Student> sortUsingDob(Map<String, Student> map)
	{
		return map.values().stream()
				.sorted(Comparator.comparing(Student::getDob))
				.collect(Collectors.toList());		
		
	}
}
