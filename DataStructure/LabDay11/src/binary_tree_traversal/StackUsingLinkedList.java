package binary_tree_traversal;



public class StackUsingLinkedList<T> {
	
	class Node
	{
		T data;
		Node next;
	}
	
	Node top;
	Node head;
	
	public StackUsingLinkedList() {
		
		top = null;
	}
	

	public void push(T i) {
		
		Node temp = new Node();
		
		
		temp.data = i;
		temp.next = top;
		top = temp;
	}

	public T pop() {
		
		if(isEmpty())
		{
			System.out.println("Stack underflow");
			return null;
		}
		
		Node temp = top;
		top = top.next;
		return temp.data;
	}

	public boolean isEmpty() {

		return top==null;
	}
	
	public int size()
	{
		int count = 0;
		Node iterator = top;
		
		while(iterator!= null)
		{
			//System.out.println("iterator");
			count++;
			iterator = iterator.next;
		}
		
		return count;
	}

	
}
