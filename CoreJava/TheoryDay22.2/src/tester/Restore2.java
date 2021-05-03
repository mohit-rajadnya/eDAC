package tester;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Product;

import static utils.IOUtils.*;

public class Restore2 {

	public static void main(String[] args) {
		
		//Java app <---- Data InputStream <---- BufferedInputStream <---- File inputStream <---- Bin file
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter file name");
			//Display only names n price of all products on separate lines
			
			Map<Integer, Product> map = restoreProduct(sc.next());
			
			map.forEach((k,v) -> System.out.println(v.getName() + "@" + v.getPrice()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
