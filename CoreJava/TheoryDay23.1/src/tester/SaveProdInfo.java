package tester;

import java.util.Scanner;
import static utils.CollectionUtils.*;
import static utils.IOUtils.*;

public class SaveProdInfo {

	public static void main(String[] args) {
		//sTORE MAP OF PRODUCTS IN A BINARY FILE , USING SERIALIZATION
		try ( Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter file name to save product details");
			saveProdDetails(populateMap(populateData()),sc.next());
			System.out.println("Saved product details");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
