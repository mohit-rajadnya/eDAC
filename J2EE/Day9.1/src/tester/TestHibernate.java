package tester;
import static utils.HibernateUtils.getSf;
import org.hibernate.*;

public class TestHibernate {
	public static void main(String args[])
	{
		try(SessionFactory factory = getSf())
		{
			System.out.println("Hibernate up and running!!" + factory);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
