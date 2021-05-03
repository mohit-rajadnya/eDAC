package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Product;

public interface IOUtils {

	//Add a static method for storing all the product details in bin file : using serialization
	
	static void saveProdDetails(Map<Integer, Product> productMap , String fileName) throws IOException
	{
		//chain of Streams
		// Java App --> ObjectO/PStrea, --> FileOutputStream --> Bin File
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			out.writeObject(productMap);
		}
	}
}
