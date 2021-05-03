package tester;

import java.util.Collections;
import java.util.List;

import com.app.core.Product;

import static utils.CollectionUtils.*;

public class Test1 {
	
	public static void main(String args[])
	{
		

	//get populated list of products
	
	List<Product> list = populateData();
	//remove all products , whose prices greater than 400 and display a list
	list.forEach(p-> System.out.println(p));
	
	list.removeIf(p -> p.getPrice()<400);
	
	list.forEach(p-> System.out.println(p));
	
	Collections.sort(list, (p1,p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate()));
	list.forEach(p-> System.out.println(p));
}
}
