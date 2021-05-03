package linkedlist;

public class LinkedlistTester {

	public static void main(String[] args) {
		
		SinglyLinkedlist s = new SinglyLinkedlist();
		
		s.addSorted(25);
		s.addSorted(10);
		
		for(int i=11 ; i<=20 ;i++)
		{
			if(i%2==0)
				s.addSorted(i);
		}
		s.addSorted(5);
		s.addSorted(21);
		s.addSorted(7);
		s.addSorted(9);
		s.addSorted(30);
		
		s.printList();
		s.deleteAll(21);
		s.printList();
		
		
	}

}
