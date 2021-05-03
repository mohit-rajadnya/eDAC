package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class SaveImageInsideDB {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf();Scanner sc=new Scanner(System.in))
		{
			//create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter user email and image file path");
			System.out.println(dao.saveImage(sc.nextLine(), sc.nextLine()));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
