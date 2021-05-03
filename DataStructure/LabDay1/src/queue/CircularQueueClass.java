package queue;

public class CircularQueueClass implements QueueInterface {
	
	private int front;
	private int rear;
	private int[] queueArr;
	private int size;
	
	

	public CircularQueueClass(int s) {
		super();
		this.front = 0;
		this.rear = 0;
		this.queueArr = new int[s];
		this.size = s;
	}

	@Override
	public void enqueue(int i) {
		
		if(!isFull())
			{
				rear = (rear + 1) % size;
				queueArr[rear] = i;
			}
		else
			System.out.println("Queue is full!!");
			

	}

	@Override
	public int dequeue() {
		if(!isEmpty())
			{
				front = (front + 1) % size;
				return queueArr[front];
				
			}
		else
			{
				System.out.println("Stack is empty");
				return -1;
			}
			
	}

	@Override
	public boolean isFull() {
		if(((rear+1)%size) == front )
			return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(rear == front)
			return true;
		return false;
	}
	
	public void displayQueue()
	{
		if(!isEmpty())

			{
				if(rear>front)
					{
						for(int i = front+1 ; i <=rear ; i++)
							System.out.print(queueArr[i] + " ");
					}
				else
				{
					for(int i = front+1 ; i<size ; i++)
						System.out.print(queueArr[i] + " ");
					
					for(int i = 0 ; i<=rear ; i++)
						System.out.print(queueArr[i] + " ");
				}
				
			}
		else
		{
			System.out.println("queue empty");
		}
	}

}
