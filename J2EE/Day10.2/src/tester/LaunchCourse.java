package tester;
import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;
public class LaunchCourse {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf(); Scanner sc = new Scanner(System.in))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Enter title , startDate , endDate , fees , Capacity");
			Course c = new Course(sc.next(), sdf.parse(sc.next()), sdf.parse(sc.next()), sc.nextDouble(), sc.nextInt());
			System.out.println(courseDao.launchNewCourse(c));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
