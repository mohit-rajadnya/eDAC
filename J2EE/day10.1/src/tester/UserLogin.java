package tester;
import static utils.HibernateUtils.getSf;
import static pojos.Role.*;
import static java.time.LocalDate.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
public class UserLogin {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf();Scanner sc=new Scanner(System.in))
		{
			//create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter email and password");
			System.out.println(dao.authenticateUser(sc.next(), sc.next()));
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
