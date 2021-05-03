package com.app.core;

//import linkedlist.SinglyLinkedlist.SinglyList;

public class SinglyLinkedList {
	
	class SinglyList
	{
		private int data;
		private SinglyList next;
	}

	private SinglyList head;
	private SinglyList tail;
	
	public SinglyLinkedList()
	{
		head = null;
		tail=null;
	}
	
	public void addFront(int n)
	{
		SinglyList s = new SinglyList();
		
		if(isEmpty())
			tail=s;
		s.data = n;
		s.next = head;
		head = s;
	}
	
	public void addLast(int n)
	{
		SinglyList s = new SinglyList();
		
		if(isEmpty())
			{
				s.data = n;
				s.next = head;
				head = s;
				tail = s;
			}
		else
			{
				s.data = n;
				s.next = null;
				tail.next=s;
				tail = s;
			}
	}

	
	public int getFront()
	{
		if(isEmpty())
			{
				return -1;
			}
		
		else 
		{
			return head.data;
		}
			
		
	}
	
	
	public void removeFront()
	{
		if(isEmpty())
		{
			tail = null;
			return;
		}
		else
			head = head.next;
	}
	
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	
	//this method will only work for stack as queues head will always be the last element, and i am not keeping a track of tail element, 
	//so ideally everytime the count for queue would return 1
	public int count()
	{
		int count = 0;
		SinglyList iterator = head;
		while(iterator!= null)
		{
			count++;
			iterator = iterator.next;
		}			
		return count;
	}
	
}
