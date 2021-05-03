package tester;

import java.util.stream.IntStream;

//Create stream of ints between 1-100 & display all even elements.
//(Hint : IntStream methods --range,filter,forEach)
public class Test5 {

	public static void main(String[] args) {
		
		IntStream.range(1, 101)//Stream of ints ranging from 1-100
		.filter(i -> i%2==0)
		.forEach(i -> System.out.print(i + " "));
	}

}
