package lab_assignment;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class assignment4_1 {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(new Integer[] {0 ,1 ,2, 3, 4, 5, 6, 7, 8, 9});
		
		ListIterator<Integer> list = arr.listIterator(7);
			while(list.hasPrevious())
				System.out.print(list.previous() + "  ");

	}

}
