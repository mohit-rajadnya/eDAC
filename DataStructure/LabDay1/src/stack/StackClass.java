package stack;

public class StackClass implements StackInterface {

	
	private int top;
	private int[] stackArr;
	private int size;
	
	public StackClass(int i)
	{
		top = -1;
		size = i;
		stackArr = new int[size];
	}
	
	
	@Override
	public void push(int i) {
		
		if(isFull())
			System.out.println("Stack is full");
		
		stackArr[++top] = i;

	}

	@Override
	public int pop() {
		
		if(isEmpty())
			{
				System.out.println("Stack is empty");
				return -1 ;
			}
			
		
		int i = stackArr[top--];
		return i;
		
		
	}

	@Override
	public boolean isFull() {
		if(top == size-1)
			return true;
		
		return false;
	}


	@Override
	public boolean isEmpty() {
		if(top == -1)
			return true;
			
			
		return false;
	}

}
