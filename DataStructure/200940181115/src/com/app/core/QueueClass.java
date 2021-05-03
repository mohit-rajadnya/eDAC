package com.app.core;

//Using same interface used for stack, as implementation methods are same
public class QueueClass implements StackInterface {
	
	private SinglyLinkedList list;
	private int size;
	
	public QueueClass(int size) {
		list = new SinglyLinkedList();	
		this.size = size;
	}

	@Override
	public void push(int i) {
		
		if(!(isFull()))
		{
			System.out.println("Element successfully added!!");
			list.addLast(i);
		}
			
		else
			{
				System.out.println("Queue Full");
				return;
			}
		
		
	}

	@Override
	public int top() {
		
		if(!(isEmpty()))
			{
				
				return list.getFront();				
			}
		
		else
		{
			System.out.println("Queue Empty");
			return -1;
		}
	}
	
	@Override
	public int pop() {
		
		if(!(isEmpty()))
			{
				int top = list.getFront();
				list.removeFront();
				return top;
			}
		else
		{
			System.out.println("Queue empty");
			return -1;
		}
			
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		if(list.count()==size)
			return true;
		return false;
	}

	

}
