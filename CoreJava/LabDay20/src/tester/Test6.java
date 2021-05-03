package tester;

import java.util.List;
import com.app.core.Category;
import java.util.Scanner;

import com.app.core.Product;
import static utils.CollectionUtils.*;

public class Test6 {

	public static void main(String[] args) {
//		Display all product names of a particular category , exceeding specific price.
//		I/P category name & price.
//		(stream,filter,forEach)
//		eg : productList : List<Product>
		
		try(Scanner sc = new Scanner(System.in))
		{
			//Populate list of products
			List<Product> list = populateData();
			
			System.out.println("Available products");
			list.forEach(p -> System.out.println(p));
			
			System.out.println("Enter category n price");
			
			Category c = Category.valueOf(sc.next().toUpperCase());
			double price = sc.nextDouble();
			
			list.stream()
			.filter((p) -> p.getPrice() == price)
			.filter(p-> p.getProductCatgeory() == c)
			.forEach(p-> System.out.println(p));
			
		}

	}

}
