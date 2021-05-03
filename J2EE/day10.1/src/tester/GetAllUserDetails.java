package tester;
import static utils.HibernateUtils.getSf;
import org.hibernate.*;

import dao.UserDaoImpl;
public class GetAllUserDetails {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf())
		{
			// create dao
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("User List");
			dao.fetchAllUserDetails().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
