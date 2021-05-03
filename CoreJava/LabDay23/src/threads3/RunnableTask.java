package threads3;
import static java.lang.Thread.currentThread;

public class RunnableTask implements Runnable{
	//RunnableTask IS NOT A thread
	//RunnableTask IS-A runnable 
		

		@Override		
		public void run()
		{
			System.out.println(currentThread().getName() + " started");
			try
			{
				for (int i =0 ; i<10 ; i++)
				{
					System.out.println(currentThread().getName() + " execution counter : " + i);
					Thread.sleep(1000);//State : Blocked on sleep
				}
				System.out.println("End of try!");
				
				
			}catch (Exception e) {
				System.out.println("Error in " + currentThread().getName() + " exc " + e);
			}
			
			System.out.println(currentThread().getName() + " over");
		}
		
}
