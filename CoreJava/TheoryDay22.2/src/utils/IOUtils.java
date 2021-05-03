package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import com.app.core.Product;

public interface IOUtils {

	//Add a static method to restore product details using de-serialization
	
	@SuppressWarnings("unchecked")
	static Map<Integer, Product> restoreProduct(String fileName) throws IOException
	{
		//validate if file : exists , regular data file(not a directory) , read permission : before creating chain of IOStreams
		//java.io.file => gives metaData of file / folder(directory) i.e abstract path that might refer to a file or a dir
		//File class ctor = File(String file path)
		File file = new File(fileName);//File class instance simply wraps a path
		if(file.exists() && file.isFile() && file.canRead())
		{
			//confirms that file is readable ,exists and is not a dir
			//Java app <--- OIS <--- FIS <--- BinFile
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)))
			{
				//de-serialisation
				
				return (Map<Integer, Product>)in.readObject();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
