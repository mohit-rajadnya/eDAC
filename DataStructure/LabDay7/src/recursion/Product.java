package recursion;

public class Product {

	public static void main(String[] args) {
			
		double p = prod(5,5);
		System.out.println(p);

	}

	public static int prod(int x , int y)
	{
		if(y==1)
			return x;
		return x + prod(x,y-1);
	}
}
