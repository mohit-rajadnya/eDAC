package linkedlist;

import java.util.LinkedList;
import static java.util.Collections.*; 

public class LinkedlistShuffling {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for (Integer i=1 ; i<=100 ; i++)
			list.add(i);
		
		
		System.out.println(list);
		
		shuffle(list);
		
		System.out.println(list);
			

	}

}
