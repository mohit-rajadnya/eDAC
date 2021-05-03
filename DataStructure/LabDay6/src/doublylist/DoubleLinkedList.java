package doublylist;

public class DoubleLinkedList {

	public class Dlist
	{
		int data;
		Dlist prev;
		Dlist next;
	}
	
	private Dlist head;
	private Dlist tail;
	
	public DoubleLinkedList()
	{
		head =null;
		tail = null;
		
	}
	
	public void addFront(int n)
	{
		Dlist s = new Dlist();
		if(head==null) // if list empty
		{
			s.next=null;
			s.prev=null;
			s.data=n;
			head=s;
			tail=s;
		}
		else
		{
			s.data=n;
			s.prev=null;
			s.next=head;
			head.prev = s;
			head=s;
			
		}
	}
	
	public void addtail(int n)
	{
		Dlist s = new Dlist();
		s.data=n;
		if(head==null)
		{
			s.next=null;
			s.prev=null;
			head=s;
		}
		else
		{
			s.next=null;
			tail.next=s;
			s.prev=tail;
			tail=s;
		}
	}
		public void printList() {
			Dlist curr = head;
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;

			}
	}
		public void insert(int elem) {
			// 1. Create a new node.
			Dlist n = new Dlist();
			// 2. Initialize new node.
			n.data = elem;
			n.prev = null;
			n.next = null;
			// 3. if list is empty
			if (head == null) {
				// 3.1 Make new node as first node
				head = n;
				// 3.2 Make new node as tail node
				tail = n;
				// 3.3 Stop
				return;
			}
			// 4. Traverse the list
			Dlist curr = head;
			// 5. While curr is pointing to a node and its data is less
			while ((curr != null) && (curr.data < n.data)) {
				// 5.1 Move curr to next node.
				curr = curr.next;
			}
			// 6. We are adding smallest value => Add new node before curr/head.
			if (curr == head) {
				// 6.1 Make new node a curr's prev node
				curr.prev = n;
				// 6.2 Make curr as new node's next node.
				n.next = curr;
				// 6.3 Make new node as new first node.
				head = n;
				// 6.4 Stop
				return;
			}
			// 7. We are adding largest value => Add new node after tail, as curr will be null.
			if (curr == null) {
				// 7.1 Make new node as next to current tail node.
				tail.next = n;
				// 7.2 Make current tail node as new node's prev node.
				n.prev = tail;
				// 7.3 Make new node as tail node.
				tail = n;
				// 7.4 Stop
				return;
			}
			// 8. Make curr as new node's next node.
			n.next = curr;
			// 9. Make curr's prev node as new node's prev.
			n.prev = curr.prev;
			// 10. Make new node as next of curr's prev node.
			curr.prev.next = n;
			// 11. Make new node as curr's prev node
			curr.prev = n;
		}
		
		public void deleteNode(int n)
		{
			Dlist curr = head;
			while(curr!=null && curr.data != n)
			{
				curr = curr.next;
			}
			if(curr == head)
			{
				if(curr == tail)
				{
					head = null;
					tail = null;
					return;
				}
				else
				{
					curr.next.prev = null;
					head = curr.next;
					return;
				}
			}
			else if(curr == tail)
			{
				curr.prev.next = null;
				tail = curr.prev;
				return;
			}
			else
			{
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
				return;
			}
		}

}
