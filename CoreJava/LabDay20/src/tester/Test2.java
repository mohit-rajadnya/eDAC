package tester;

import java.util.Map;
import static utils.CollectionUtils.*;

import com.app.core.Product;

public class Test2 {
	
	public static void main (String args[])
	{
		Map<Integer, Product> map = populateMap(populateData());
		//Objective : to print in separate lines == Name of prod : Price
		
		map.forEach((n , p) -> System.out.println("Name: " + p.getName()+ "Price : " + p.getPrice()));
	}

}
