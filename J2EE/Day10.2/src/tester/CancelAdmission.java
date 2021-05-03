package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;


public class CancelAdmission {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf(); Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl s = new StudentDaoImpl();
			System.out.println("Enter courseName , studentId");
			System.out.println(s.cancelAdmission(sc.next(), sc.nextInt()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
