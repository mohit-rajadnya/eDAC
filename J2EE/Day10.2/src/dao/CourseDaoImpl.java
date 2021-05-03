package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		String message = "Launching new course failed";
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			session.persist(c);
			tx.commit();
			message = "launched a course with course ID " + c.getId();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return message;
	}

	@Override
	public String cancelCourse(int courseId) {
		String message = "Failed to delete the course";
		
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			Course c = session.get(Course.class, courseId);
			if(c!=null)
			{
				session.delete(c);//marked for removal , neither gone from L1 nor DB
			}
			tx.commit();//auto dirty checking : deletes all asso child records then parent record
			message = "cancelled course: " + c.getTitle();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return message;
	}

	@Override
	public Course displayDetails(String courseName) {
		String jpql = "select c from Course c where title= :title";
		
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
		
			tx.commit();
			return c;
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		
	}

}
