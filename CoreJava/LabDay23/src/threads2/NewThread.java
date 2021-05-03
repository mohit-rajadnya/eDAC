package threads2;
import static java.lang.Thread.currentThread;

public class NewThread extends Thread{
	
		public NewThread(String name)

		{
			super(name); //thread is new thread state i.e thread class instance is created on heap but 
			//separate flow of execution has not yet started
			start();//state : RUNNABLE (ready to run pool or maybe running)  , create separate flow of control
			System.out.println("in ctor by " + currentThread().getName());// will give output as main
			//run();//fatal mistake , same flow of execution as invoker method. No concurrency is present
		}

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
