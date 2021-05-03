package tester;

import doublylist.DoubleLinkedList;

public class DListTester {

	public static void main(String[] args) {
	DoubleLinkedList list = new DoubleLinkedList();
		
		list.addFront(10);
		list.addtail(15);
		list.insert(12);
		list.addtail(4);
		list.addFront(6);
		list.insert(5);
		list.printList();
		
		list.deleteNode(6);
		list.deleteNode(12);
		System.out.println();
		list.printList();
	}
	}


