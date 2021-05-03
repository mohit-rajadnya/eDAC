package queue;

public interface QueueInterface {
	
	void enqueue(int i);
	int dequeue();
	boolean isFull();
	boolean isEmpty();
}
