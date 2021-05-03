package copy_api.tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import problem18_3.copy_api.Emp;
import problem18_3.copy_api.SalesManager;

public class CopyAPITester {

	public static void main(String[] args) {
		ArrayList<Emp> emps = new ArrayList<>(Arrays.asList(new Emp(),new Emp(),new Emp(),new Emp()));
		Vector<SalesManager> mgr = new Vector<SalesManager>(Arrays.asList(new SalesManager(),new SalesManager() , new SalesManager()));
		Collections.copy(emps, mgr);
		
		System.out.println(emps);
	}

}
