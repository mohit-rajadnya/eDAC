package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;
public class DisplayCourseDetails {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf(); Scanner sc = new Scanner(System.in))
		{
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Enter course name");
			Course c = courseDao.displayDetails(sc.next());
			System.out.println(c);
			System.out.println("Student details associated with the course:");
			c.getStudents().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
