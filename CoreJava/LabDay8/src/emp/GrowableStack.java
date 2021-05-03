package emp;

public class GrowableStack implements Stack 
{
	
	private Employees[] e;
	private int top;

	public GrowableStack() {
		e = new Employees[STACK_SIZE];
		top = -1;
	}

	@Override
	public void push(Employees p)
	{
		
		if(top<e.length-1)
						
				e[++top] = p;
		else
		{
			Employees[] e1 = new Employees[e.length * 2];
			
			for(int i=0 ; i < e.length ; i++)
			{
				e1[i] = e[i];
			}
			
			
			e = e1;
			e[++top] = p;
		}
	}

	@Override
	public Employees pop() {
		
	int count=0;
	for(Employees temp: e)
	{
		if(temp == null)
			count++;
	}
	if(count == (e.length - 1))
		{
		System.out.println("Stack is empty");
		return null;
		}
	else
		return e[top--];
	}

	public int getTop() {
		return top;
	}

	@Override
	public Employees[] getE() {
		return e;
	}
	
	
}



/*
 @Override
	public void push(Employee emp) {
		
		if(top == employees.length-1) {
			
			Employee[] employeesNew = new Employee[employees.length * 2];
			
//			employeesNew = employees;
			
			for(int i = 0; i < employees.length; i++) {
				
				employeesNew[i] = employees[i];
				
			}
			
			employees = employeesNew;
		}
	
		employees[++top] = emp;
			
	}*/
