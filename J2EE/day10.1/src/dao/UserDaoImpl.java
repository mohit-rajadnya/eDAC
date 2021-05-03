package dao;

import static utils.HibernateUtils.getSf;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Role;
import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		// user : exists only in heap , not in L1 cache , not in DB : TRANSIENT
		String mesg = "user registration failed...";
		// get session from SF
		Session session = getSf().openSession();
		Session session2 = getSf().openSession();
		System.out.println("sessions same " + (session == session2));// false
		// begin tx
		Transaction tx = session.beginTransaction(); // L1 cache is created : EMPTY
		System.out
				.println("is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t
																														// t

		try {
			Integer id = (Integer) session.save(user);// user ref is simply added under L1 : PERSISTENT
			// success
			tx.commit();// hibernate performs auto dirty chking @ commit : DML : insert query
			mesg = "user reged successfully , ID =" + id;
			System.out.println(
					"is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t t

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();// L1 cache is destroyed n db conn rets to the pool , closing the session
		}
		System.out
				.println("is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// f
																														// f

		// user : DETACHED
		return mesg;
	}

	@Override
	public String registerUserWithGetCurntSession(User user) {
		String mesg = "user registration failed...";
		// get session from SF : getCurrentSession
		Session session = getSf().getCurrentSession();
		Session session2 = getSf().getCurrentSession();
		System.out.println(session == session2);// true
		// begin tx
		Transaction tx = session.beginTransaction();
		System.out
				.println("is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t
																														// t
		try {
			session.persist(user);// user ref is simply added under L1 : PERSISTENT
			// success
			tx.commit();// hibernate performs auto dirty chking @ commit : DML : insert query & L1 cache
						// is destroyed n db conn rets to the pool , closing the session
			mesg = "user reged successfully , ID ";
			System.out.println(
					"is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t t

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			System.out.println("rollback : is session open ?" + session.isOpen() + " is connected with db cn "
					+ session.isConnected());// t t

			throw e;
		}
		return mesg;
	}

	@Override
	public User getUserDetails(int userId) {
		User u = null;// u : NA 
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			//Session API : public <T> T get(Class<T> pojoCls,Serializable id) throws HibernateException
			u=session.get(User.class,userId);//int ---> Integer --> Serializable
			u=session.get(User.class,userId);//int ---> Integer --> Serializable
			u=session.get(User.class,userId);//int ---> Integer --> Serializable // u : in case of valid id : PERSISTENT
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return u;// u : DETACHED
	}

	@Override
	public List<User> fetchAllUserDetails() {
		String jpql="select u from User u";
		List<User> userList=null;
		// get session
				Session session = getSf().getCurrentSession();
				// begin tx
				Transaction tx = session.beginTransaction();
				try {
					userList=session.createQuery(jpql, User.class).getResultList();
					//execute query -- rst -- processing of rst : user;s def ctor -- setters -ref will 
					//be added to L1 cache -- will also be added to list
					//Method rets list of persistant pojo/entities to caller
					//The results of getResultlist are not cached automati
					//you  will have to explicitly enable Query level cache to enable it
					tx.commit();
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback(); // L1 cache
					// is destroyed n db conn rets to the pool , closing the session
					throw e;
				}
		return userList;
	}

	@Override
	public List<User> fetchSelectedUserDetails(LocalDate start, LocalDate end, Role user) {
		String jpql = "select u from User u where u.regDate between :strt and :end and u.userRole = :rl";
		
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		List<User> userList=null;
		try {
			userList=session.createQuery(jpql, User.class).setParameter("strt", start).setParameter("end", end).setParameter("rl", user).getResultList();
			tx.commit();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return userList;
	}

	@Override
	public User authenticateUser(String email, String password) {
		User user = null;
		String jpql = "select u from User u where u.email= :email and :password= :password";
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			user=session.createQuery(jpql, User.class).setParameter("email", email).setParameter("password", password).getSingleResult();
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();			
			System.out.println("Invalid login!!");
			throw e;
			
		}
		return user;
	}

	@Override
	public List<User> fetchSelectedUserNames(LocalDate start, LocalDate end, Role user) {
		String jpql = "select new pojos.User(name,regAmount,regDate) from User u where u.regDate between :strt and :end and u.userRole = :rl";
		List<User> userList = null;
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			userList=session.createQuery(jpql, User.class).setParameter("strt", start).setParameter("end", end).setParameter("rl", user).getResultList();
			tx.commit();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return userList;
	}

	@Override
	public String changePassword(int userId, String newPwd) {
		String message = "Password updation failed";
		User u = null;
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			u=session.get(User.class, userId);
			if(u!=null)
			{
				//valid id u : persistent(as it exists in L1 cache)
				u.setPassword(newPwd);//updating state of persistent pojo
				session.evict(u);
				message = "Password updated";
			}
			tx.commit();//hib auto performs auto dirty checking : updateQuery, L1 cache is closed/destroyed
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		if(u!=null)
			u.setPassword("9999");//no automatic dirty checking as pojo is detached
		return message;
	}

	@Override
	public String applyDiscount(double discount, LocalDate date) {
		String message = "Applying discount failed";
		String jpql = "update User u set u.regAmount=u.regAmount - :amt where u.userRole = :role and u.regDate< :dt";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			int updateCount = session.createQuery(jpql).setParameter("amt", discount).setParameter("role", Role.ADMIN).setParameter("dt", date).executeUpdate();
			tx.commit();
			System.out.println("Discount applied to " + updateCount + " admins");
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return message;
	}

	@Override
	public String deleteUserDetails(int userId) {
		String message = "Deletion failed";
		
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			User user = session.get(User.class, userId);
			if(user!=null)
			{
				//user : persisent
				session.delete(user);//user:removed(Present yet in L1 , marked for removal)
				//session.evitct(user);//evicts the entity from L1 and no chnge happens on db
				message = "Deletion successful";
			}
			
			tx.commit();//delete checking : delete query is fired , L1 cache destroyed , db cn rets to the conn pool : session is closed
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		//user:transient
		return message;
	}//user obj is marked for garbage collection

	@Override
	public String saveImage(String email, String imageFilePath) throws IOException {
		String message = "Saving image failed, invalid email";
		String jpql = "select u from User u where u.email = :email";
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			//get user details from db by email
			User u = session.createQuery(jpql, User.class).setParameter("email", email).getSingleResult();
			//u=>persistent
			File file = new File(imageFilePath);
			if(file.exists()&&file.isFile()&&file.canRead())
			{
				u.setImage(FileUtils.readFileToByteArray(file));
				message = "saving image successful";
			}
			else
			{
				message = "saving image failed: invalid image path";
			}
				tx.commit();
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return message;
	}

	@Override
	public String restoreImage(int userId, String destImagePath) throws IOException {
		
		String message ="Restoring failed , invalid userId";
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			User u = session.get(User.class , userId);
			if(u!=null)
			{
				File f1 = new File(destImagePath);
				//API used public static void writeByteArrayToFile(File file , byte[)] data
				FileUtils.writeByteArrayToFile(f1, u.getImage());
				message = "Restoration successful";
			}
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return message;
	}

}
