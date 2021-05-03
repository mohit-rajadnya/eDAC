package tester;
import static utils.HibernateUtils.getSf;
import static pojos.Role.*;
import static java.time.LocalDate.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
public class FetchSelectedUserDetails {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf();Scanner sc=new Scanner(System.in))
		{
			//create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter begin date , end date , role");
			dao.fetchSelectedUserDetails(parse(sc.next()), parse(sc.next()), valueOf(sc.next().toUpperCase())).forEach(System.out::println);
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
