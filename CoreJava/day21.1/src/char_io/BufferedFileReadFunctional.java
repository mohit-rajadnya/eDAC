package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedFileReadFunctional {
	
	public static void main(String args[])
	{
		System.out.println("Enter file name along with path");
		try(Scanner sc = new Scanner (System.in);BufferedReader br = new BufferedReader(new FileReader(sc.nextLine())))
		{
			
			//functional style
			br.lines()//Stream<String> => line
			.forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
