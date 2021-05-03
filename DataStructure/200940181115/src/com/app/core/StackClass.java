package com.app.core;

public class StackClass implements StackInterface {
	
	private SinglyLinkedList list;
	private int size;
	
	public StackClass(int size) {
		list = new SinglyLinkedList();	
		this.size = size;
	}

	@Override
	public void push(int i) {
		
		if(!(isFull()))
		{
			System.out.println("Element successfully added!!");
			list.addFront(i);
		}
			
		else
			{
				System.out.println("Stack overflow");
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
			System.out.println("Stack underflow");
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
			System.out.println("Stack underflow");
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
