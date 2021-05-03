package linkedlist;

public class SinglyLinkedlist {
	
	class SinglyList
	{
		private int data;
		private SinglyList next;
	}

	private SinglyList head;
	private SinglyList tail;
	
	public SinglyLinkedlist()
	{
		head = null;
		tail = null;
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
			addFront(n);
		
		else
			{
				s.data = n;
				s.next = null;
				tail.next = s;
				tail = s;
			}
	}

	
	public void printList()
	{
		SinglyList iterator = head;
		while(iterator!= null)
		{
			//System.out.println("iterator");
			System.out.print(iterator.data + " ");
			iterator = iterator.next;
		}			
		
	}
	
	public void addSorted(int n)
	{
		SinglyList s = new SinglyList();
		s.data = n;
		s.next = null;
		SinglyList curr = head;
		SinglyList prev = null;
		
		while(curr!=null && curr.data < n)
		{
			//System.out.println("Inside while loop");
			prev = curr;
			curr = curr.next;
		}
		if(prev == null)
			{
				//System.out.println("Inside add front");
				addFront(n);
			}
		else if(curr == null)
			{
				//System.out.println("inside add last");
				addLast(n);
			}
		else
			{
				//System.out.println("Inside add in between");
				prev.next = s;
				s.next = curr;
			}				
		
	}
	
	public boolean removeElement(int n)
	{
	
		SinglyList curr = head;
		
		if(head == null)
			return false;
		
		if(head.data == n)
			{
				head = head.next;
				return true;
			}
		
		while(curr!=null && curr.next.data != n)
		{
			curr = curr.next;
		}
		
		if(curr.next!=null)
		{
			curr.next = curr.next.next;
			return true;
		}
		return false;
		
	}
	
	public boolean isEmpty()
	{
		if(head==null && tail == null)
			return true;
		return false;
	}
	
	public boolean deleteAll(int elem) {
		SinglyList curr = head;
		boolean done = true;
		while (curr != null) {
			while (curr.data == elem) {
				done = removeElement(curr.data);
				if (!done) {
					break;
				}
			}
			curr = curr.next;
		}
		return done;
	}
	
	}













