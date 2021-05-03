package tester;
import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;
public class LaunchCourseWithStudents {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf(); Scanner sc = new Scanner(System.in))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Enter title , startDate , endDate , fees , Capacity");
			Course c = new Course(sc.next(), sdf.parse(sc.next()), sdf.parse(sc.next()), sc.nextDouble(), sc.nextInt());
			
			boolean flag = true;
			
			while(flag)
			{
				System.out.println("Enter student details name , email or quit to exit");
				String name = sc.next();
				if(name.equalsIgnoreCase("quit"))
					flag = false;
				else
				c.addStudent(new Student(name, sc.next()));
			}
			
			System.out.println(courseDao.launchNewCourse(c));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
