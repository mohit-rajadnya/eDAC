package recursion;

public class Fibonacci {

	public static void main(String[] args) {
	
		int x = f(5);
		 
		System.out.println(x);
		
	}
	
	public static int f(int n)
	{
		if((n==1)||(n==2))
				return 1;
		return f(n-1) + f(n-2);
	}

}
