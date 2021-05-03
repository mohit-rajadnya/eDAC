package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSf;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitStudent(Student s, String courseTitle) {
		String message = "Addmission failed!!";
		String jpql="select c from Course c where c.title = :title";
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			//get the course details by the course title
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseTitle).getSingleResult();
			//c:persistent
			//if you update the state of the persistent entity : hibernate auto propagates changes into db
			//add student ref to course
			//this approach will work along with cascading
			//will add it later
			//Without cascading?
			//use case : unidirectional many-to-one : efficient
			//establish the link from student to the course
			
			
			//c.getStudents().add(s);
			//s.setSelectedCourse(c);// for establishing reverse asso from child to parent
			c.addStudent(s);//helper method added in course class
			
			System.out.println("course: "+s.getSelectedCourse());
			//session.persist(s); // option for cascading
			tx.commit();
			message = "Your student enrolled!!";
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return message;
	}

	@Override
	public String cancelAdmission(String courseName, int studentId) {
		String message = "Failed to cancel your addmission";
		String jpql="select c from Course c where c.title = :title";
		Session session = getSf().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			Student s = session.get(Student.class,studentId);
			if(s!=null)
			{
				c.removeStudent(s);
				message = "cancelled admission for student " + s.getName();
			}
			c.removeStudent(s);
			tx.commit();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();			
			throw e;
		}
		return message;
	}

}
