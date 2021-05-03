package queue;

public class QueueClass implements QueueInterface {
	
	private int front;
	private int rear;
	private int[] queueArr;
	private int size;
	
	

	public QueueClass(int s) {
		super();
		this.front = -1;
		this.rear = -1;
		this.queueArr = new int[s];
		this.size = s;
	}

	@Override
	public void enqueue(int i) {
		
		if(!isFull())
			{
				if(front==-1)
					front++;											
				queueArr[++rear] = i;						
			}
		else
			System.out.println("Queue is full!!");
			

	}

	@Override
	public int dequeue() {
		if(!isEmpty())
			{
				int temp = queueArr[front++];
				return temp;
			}
		else
			{
				System.out.println("Stack is empty");
				return -1;
			}
			
	}

	@Override
	public boolean isFull() {
		if(rear == size-1)
			return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(rear < front)
			{
				front = rear = -1;
				return true;
			}
			
		return false;
	}
	
	public void displayQueue()
	{
		if(!isEmpty())

			{
				for(int i : queueArr)
				System.out.print(i + " " );
			}
		else
		{
			System.out.println("queue empty");
		}
	}

}
