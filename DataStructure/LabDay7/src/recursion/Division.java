package recursion;

public class Division {

	public static void main(String[] args) {
			
		double p = div(25,5);
		System.out.println(p);

	}

	public static int div(int x , int y)
	{
		if(x<y)
			{System.out.println("Remainder: " + x);
			return 0;
			}
		
		return div(x-y,y);
	}
}
