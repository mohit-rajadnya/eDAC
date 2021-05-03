package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.app.core.Student;

public interface IOUtils {
	
	//store sorted student details in a text file
	
	static void writeDate(List<Student> list , String filename) throws IOException
	{
		//java app   --->  PW  ---> FW  --->  txt 
		
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename)))
		{
			list.forEach(s->pw.print(s));
			//or --> list.forEach(pw::println);
			
			//for(Student s : list)
				//System.out.println(s);
		}
	}

}
