package tester;

import java.util.List;
import com.app.core.Category;
import java.util.Scanner;

import com.app.core.Product;
import static utils.CollectionUtils.*;

public class Test8 {

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
			
			System.out.println("Enter category");
			
			Category c = Category.valueOf(sc.next().toUpperCase());
			
			double sumPrice = list.stream()
			.filter(p -> p.getProductCatgeory().equals(c))
			.mapToDouble(p-> p.getPrice())//stream of doubles which indicate prices of product : DoubleStream
			.sum();
			
			System.out.println("Sum of prices of the producst in that category: " + sumPrice);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
