package dao;

import pojos.Course;

public interface ICourseDao {
	
	String launchNewCourse(Course c);//c: transient
	String cancelCourse(int courseId);
	Course displayDetails(String courseName);

}
