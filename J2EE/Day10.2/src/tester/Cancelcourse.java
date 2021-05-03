package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
public class Cancelcourse {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf(); Scanner sc = new Scanner(System.in))
		{
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Enter Id");
		
			System.out.println(courseDao.cancelCourse(sc.nextInt()));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
