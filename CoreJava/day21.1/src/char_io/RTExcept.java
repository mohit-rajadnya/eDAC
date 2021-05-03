package char_io;

public class RTExcept {
public static void throwit () {
System.out.print("throw it ");
throw new RuntimeException();
}
public static void main(String [] args) {
	
	test(1,2);
try {
System.out.print("hello ");
throwit();
}
catch (Exception re ) {
System.out.print("caught ");
}
finally {
System.out.print("finally ");
}
System.out.println("after ");
}
public static void test(int x, float y)
{
	char b1 = 0;
	String a = "newspaper";
	a = a + b1;
	char b = a.charAt(1);
	System.out.println(b);
	a = a + b;
	System.out.println(a);
}
}

