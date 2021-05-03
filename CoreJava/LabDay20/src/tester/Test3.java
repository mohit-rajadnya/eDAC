package tester;

import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		
		int[] data = {12,56,54,667,23,57,34,762,36,56};
		//Arrays.stream(int[]array): java.util.stream.Intstream : i/f
		
		Arrays.stream(data)
		.forEach(i -> System.out.print(i + " "));
	}

}
