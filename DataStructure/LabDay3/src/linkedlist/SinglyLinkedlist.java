package linkedlist;

public class SinglyLinkedlist {
	
	class SinglyList
	{
		private int data;
		private SinglyList next;
	}

	private SinglyList head;
	
	public SinglyLinkedlist()
	{
		head = null;
	}
	
	public void addFront(int n)
	{
		SinglyList s = new SinglyList();
		s.data = n;
		s.next = head;
		head = s;
	}
	
	public void printList()
	{
		SinglyList iterator = head;
		while(iterator!= null)
		{
			System.out.print(iterator.data + " ");
			iterator = iterator.next;
		}			
		
	}
	
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
	
	public int countFrequency(int n)
	{
		int count = 0;
		SinglyList iterator = head;
		while(iterator!= null)
		{
			if(iterator.data == n)
				count++;
			iterator = iterator.next;
		}	
		return count;
	}
	
	public boolean find(int n)
	{
		SinglyList iterator = head;
		while(iterator!= null)
		{
			if(iterator.data == n)
				return true;
			iterator = iterator.next;
		}	
		return false;
	}
}













