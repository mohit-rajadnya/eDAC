package tester;

import java.util.ArrayList;
import java.util.Arrays;

//Create AL<Integer> , populate it.
//Convert it to seq stream & display elems
//Convert it to parallel stream & display elems

public class Tester4 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12,35,34,64,54,345,23,46,43,45));
		
		//convert collection to a sequential stream -- collection i/f : Stream<>
		list.stream()//stream of type integer returned (Stream<Integer>)
		.forEach(i-> System.out.print(i + " "));
		
		System.out.println();
		//convert collection to a parallel stream --  collection i/f : parallelstream<>
		list.parallelStream()
		.forEach(i-> System.out.print(i + " "));
	}

}
