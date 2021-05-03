package runnable_tasks;
import static java.lang.Thread.currentThread;
import static utils.IOUtils.writeDate;
import static utils.StudentCollectionUtils.*;

import java.util.Map;

import com.app.core.Student;

public class DOBSorter implements Runnable{
	
	private Map<String, Student> map;
	private String fileName;

	public DOBSorter(Map<String, Student> map, String fileName) {
		super();
		this.map = map;
		this.fileName = fileName;
		System.out.println("in ctor of " + getClass().getName() + " invoked by " + currentThread().getName());
	}

	@Override
	public void run() {
		
		System.out.println(currentThread().getName() + " started");
		
		try
		{
			
			
			writeDate(sortUsingDob(map), fileName);
			
			
			
		}catch (Exception e) {
			System.out.println(currentThread().getName() + " has error " + e);
		}
		System.out.println(currentThread().getName() + " over");
	}

	
}
