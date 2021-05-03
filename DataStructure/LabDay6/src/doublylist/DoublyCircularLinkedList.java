package doublylist;

public class DoublyCircularLinkedList {
	
	public class DList
	{
		private int data;
		private DList prev;
		private DList next;
	}
	
	public DList head; 
	
	public DoublyCircularLinkedList()
	{
		head = new DList();
		head.next = head;
		head.prev = head;
	}
		
	public void printList()
	{
		DList curr = head.next;
	
		while(curr!=head)
		{
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	
	public void insert(int n)
	{
		DList s = new DList();
		s.data = n;
		s.next = null;
		s.prev = null;
	
		DList curr = head.next;
		while(curr!=head && curr.data < n)
			curr = curr.next;
		s.next = curr;
		s.prev = curr.prev;
		curr.prev.next = s;
		curr.prev = s;
		return;
	}
	
	public void delete(int num) {
		DList curr = head.next;
		while ((curr != head) && (curr.data != num)) {
			curr = curr.next;
		}

		if (curr == head) {
			return;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
	}
	
	public void printReverseList()
	{
		DList curr= head.prev;
		
	}

}


























