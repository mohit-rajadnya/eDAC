package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.app.core.Category.*;
import static java.time.LocalDate.*;

import com.app.core.Product;
import com.app.core.ShipmentDetails;

public interface CollectionUtils {
	static List<Product> populateData() {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(100, "mango", FRUITS, parse("2019-01-01"), 500));
		products.add(new Product(10, "rice_bran", OIL, parse("2019-11-21"), 450));
		products.add(new Product(45, "sunflower", OIL, parse("2019-05-11"), 550));
		products.add(new Product(30, "rice", GRAINS, parse("2019-01-13"), 520));
		products.add(new Product(55, "orange", FRUITS, parse("2020-01-01"), 350));
		products.add(new Product(35, "wheat", GRAINS, parse("2018-07-11"), 700));
		//assign shipment details to products
		List<ShipmentDetails> details = Arrays.asList(new ShipmentDetails("pune", "12345", "45657857", now()),
				new ShipmentDetails("mumbai", "12345", "45657857", now()),
				new ShipmentDetails("delhi", "12345", "45657857", now()),
				new ShipmentDetails("indore", "12345", "45657857", now()),
				new ShipmentDetails("pune", "12345", "67657857", now()),
				new ShipmentDetails("pune", "42345", "88657857", now()));
		//link 
		for(int i=0;i<products.size();i++)
			products.get(i).linkShipmentDetails(details.get(i));
		
		
		return products;
	}
	static Map<Integer, Product> populateMap(List<Product> products)
	{
		HashMap<Integer, Product> map=new HashMap<>();
//		for(Product p : products)
//			map.put(p.getId(), p);
		
		products.forEach(p -> map.put(p.getId(), p));
		return map;
	}
	
}
