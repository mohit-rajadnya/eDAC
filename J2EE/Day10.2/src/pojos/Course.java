package pojos;
//id(will be inherited from baseclass) , title , strtdate,enddate,fees,capacity,List<Student>

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="course_tbl")
public class Course extends BaseEntity {

	@Column(length = 30)
	private String title;
	@Temporal(TemporalType.DATE)//required only for older synttax..not for LocalDate
	@Column(name="start_name")
	private Date startDate;
	@Column(name="end_name")
	private Date endDate;
	private double fees;
		private int capacity;
	//one many association
		//Mapped by must be name of property as it appears in owning side
	@OneToMany(mappedBy = "selectedCourse" , cascade=CascadeType.ALL , orphanRemoval = true /*,fetch = FetchType.EAGER*/)
	private List<Student> students = new ArrayList<Student>();
	
	//def ctor
	public Course(String title, Date startDate, Date endDate, double fees, int capacity) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public Course()
	{
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//tip : to avoid recursion, never add any asso based property in toString

	@Override
	public String toString() {
		return "Course [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", fees=" + fees
				+ ", capacity=" + capacity + "]";
	}
	
	//add helper methods for bi-directional association for establishing a link between parent and vice versa
	//not mandatory but recommendation high
	public void addStudent(Student s)
	{
		students.add(s); //parent --> child
		s.setSelectedCourse(this); //child-->parent
	}
	public void removeStudent(Student s)
	{
		students.remove(s);
		s.setSelectedCourse(null);
	}
}
