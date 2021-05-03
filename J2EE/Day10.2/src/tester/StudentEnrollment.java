package tester;
import static utils.HibernateUtils.getSf;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.StudentDaoImpl;
import pojos.Student;


public class StudentEnrollment {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf(); Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl s = new StudentDaoImpl();
			System.out.println("Enter name , email , course name ");
			System.out.println(s.admitStudent(new Student(sc.next(), sc.next()), sc.next()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
