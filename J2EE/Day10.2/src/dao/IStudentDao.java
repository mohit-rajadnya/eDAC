package dao;

import pojos.Student;

public interface IStudentDao {

	String admitStudent(Student s , String courseTitle);
	String cancelAdmission(String courseName , int StudentId);
}
