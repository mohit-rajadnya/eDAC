package emp;

public class Employees {
	
	private int id ;
	private String name;
	private double salary;

	public Employees(int id , String nm , double sal) {
		this.id = id;
		name = nm;
		salary = sal;
	}
	
	public String toString()
	{
		return "ID: " + id + " Name: " + name + " Salary: " + salary;
	}

}
