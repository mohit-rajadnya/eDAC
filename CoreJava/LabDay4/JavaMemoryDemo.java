package com.test.util;

// java JavaMemoryDemo 100 200
// rt.jar (contains all java lib classes)
public class JavaMemoryDemo {
	private static int objCount;
	
	private int id;
	private String name;
	
	public JavaMemoryDemo() {
		objCount++;
	}
	
	public JavaMemoryDemo(int id, String name) {
		this.id = id;this.name = name;
		objCount++;
	}

	public void displayDetails() {
		String message ="This is object details";
		System.out.println(id +" ,"+ name +" ," + JavaMemoryDemo.objCount);
	} 
	
	public String getName() {
		return name;
	}
	
	public static int getObjCount() {
		return objCount;
	}
	
	
	public static void main(String[] args) {
		JavaMemoryDemo obj = new JavaMemoryDemo();
		obj.displayDetails();
		
		JavaMemoryDemo obj2 = new JavaMemoryDemo(101,"test");
		obj2.displayDetails();
		
		String name2 = obj2.getName();
		System.out.println(name2); 
		//System.out.println(objCount); 
	}

}



