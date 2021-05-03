package pojos;

import javax.persistence.*;

@Entity
@Table(name="students_tbl")
public class Student extends BaseEntity {
	
	@Column(length=30)
	private String name;
	@Column(length=30 , unique=true)
	private String email;
	//many to one association
	@ManyToOne
	@JoinColumn(name="course_id", nullable= false)
	private Course selectedCourse;
	public Student() {
		System.out.println("in student ctor");
	}
	@Override
	public String toString() {
		return "Student [StudentID" + getId()+ ", name=" + name + ", email=" + email + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}
