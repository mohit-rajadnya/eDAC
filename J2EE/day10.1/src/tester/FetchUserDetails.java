package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
public class FetchUserDetails {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf();Scanner sc=new Scanner(System.in))
		{
			//create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter user id");
			System.out.println(dao.getUserDetails(sc.nextInt()));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
