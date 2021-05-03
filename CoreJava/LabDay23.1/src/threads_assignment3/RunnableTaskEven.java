package threads_assignment3;
import static java.lang.Thread.currentThread;

public class RunnableTaskEven implements Runnable {
	
	private int start ;
	private int end;
	
	public RunnableTaskEven(int strt , int end)
	{
		start = strt;
		this.end = end;
	}
	
	public void run()
	{
		System.out.println(currentThread().getName()+ " started");
		
		try
		{
		for(int i = start ; i <= end ; i++)
			{if(i%2==0)
				{System.out.println(currentThread().getName()  + " : " + i);
				Thread.sleep(400);}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("End of " + currentThread().getName() + "thread!!");
	}

}
