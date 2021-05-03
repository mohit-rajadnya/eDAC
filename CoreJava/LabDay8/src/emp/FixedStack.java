package emp;

public class FixedStack implements Stack {
	
	private Employees[] e;
	private int top;


	public FixedStack() 
	{
		e = new Employees[STACK_SIZE];
		top = -1;
	}
	
	@Override
	public void push(Employees p) {
		
	if(top<STACK_SIZE-1)
				
		e[++top] = p;
	else
		System.out.println("Stack is full");
	}

	public int getTop() {
		return top;
	}

	@Override
	public Employees pop() {
		
	int count=0;
	for(Employees temp: e)
	{
		if(temp == null)
			count++;
	}
	if(count == STACK_SIZE)
		{
		System.out.println("Stack is empty");
		return null;
		}
	else
		return e[top--];
	}
	
	@Override
	public Employees[] getE() 
	{
		return e;
	}

}
