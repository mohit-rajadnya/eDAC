package dao;

import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

import java.util.List;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		//user : exists only in heap. not in L1 cache, not in DB:Transient
		String message = "user reg failed";
		//get session from session factory
		Session session = getSf().openSession();
		Session session2 = getSf().openSession();
		System.out.println("sessions same" + (session == session2));//false as openSession used
		//begin tx
		Transaction tx = session.beginTransaction();//L1 cache created : Empty
		System.out.println("is session open?" + session.isOpen() + "is connected with db cn" + session.isConnected() ) ;// t t
		try
		{
			Integer id = (Integer)session.save(user);//user ref is simply added under L1 : Persistent state
			//if successful
			tx.commit();//hibernate performs automatic dirty check @ commit : DML : insert query
			message = "user reg successful ,ID" + id;
			System.out.println("is session open?" + session.isOpen() + "is connected with db cn" + session.isConnected() ) ;//t t
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}finally{
			if(session!=null)
			 session.close();//L1 cache is destroyed n the db connection returns to the pool, closing the session
			System.out.println("is session open?" + session.isOpen() + "is connected with db cn" + session.isConnected() ) ;//f f
		}
		return message;
	}

	@Override
	public String registerUserWithGetCurrentSession(User user) {
		//get session from your session factory  using getcurrent session
		String message = "user reg failed";
		Session session = getSf().getCurrentSession();
		Session session2 = getSf().getCurrentSession();
		System.out.println(session == session2);//true
		//begin a tx
		Transaction tx = session.beginTransaction();
		System.out.println("is session open?" + session.isOpen() + "is connected with db cn" + session.isConnected() ) ;//t t
		try {
		Integer id = (Integer)session.save(user);//user ref is simply added under L1 : Persistent state
		//if successful
		tx.commit();//hibernate performs automatic dirty check @ commit : DML : insert query also closes the session
		message = "user reg successful ,ID" + id;
		System.out.println("is session open?" + session.isOpen() + "is connected with db cn" + session.isConnected() ) ;//f f
	
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			//L! cache will be destroyed and db cn rets to pool, session gets closed
			throw e;
		}
		
		
		return message;
	}

	@Override
	public User getUserDetails(int userId) {
		User u = null;
		//Get session 
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			//session API : public<T> T get(Class<T>pojoClass,Serializable ID) throws HibernateException
			u=session.get(User.class, userId);
			u=session.get(User.class, userId);
			u=session.get(User.class, userId);
			tx.commit();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		
		return u;
	}

	@Override
	public List<User> fetchAllUserDetails() {
		String jpql="select u from User u";
		List<User> userList = null;
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			userList = session.createQuery(jpql, User.class).getResultList();
			tx.commit();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		
		return userList;
	}

}
