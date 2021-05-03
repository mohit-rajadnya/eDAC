package singly.array;

public class tester{
	public static void main(String[] args) {
		SListUsingArray sl = new SListUsingArray(10);

		System.out.println("Print list - empty list.");
		sl.print();

		sl.insert(5);
		sl.insert(10);
		sl.insert(1);
		sl.insert(2);
		sl.delete(2);
		System.out.println("Print list - 1 2 5 10.");
		sl.print();
	}
}
