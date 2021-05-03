package linkedlist;

public class LinkedlistTester {

	public static void main(String[] args) {
		
		SinglyLinkedlist s = new SinglyLinkedlist();
		
		s.addFront(25);
		for (int i = 1 ; i<=10 ; i++)
			s.addFront(i);
		
		s.addFront(4);
		s.addFront(4);
		
		s.printList();
		System.out.println("Count: " + s.count());
		System.out.println("Frequency of 4: " + s.countFrequency(4));
		System.out.println(s.find(20));
		System.out.println(s.find(4));
		
	}

}
