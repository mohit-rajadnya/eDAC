package tester;

import java.util.Scanner;
import static utils.IOUtils.*;

public class Restore {

	public static void main(String[] args) {
		
		//Java app <---- Data InputStream <---- BufferedInputStream <---- File inputStream <---- Bin file
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter file name");
			System.out.println(restoreProduct(sc.next()));
			//System.out.println("Data restored!");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
