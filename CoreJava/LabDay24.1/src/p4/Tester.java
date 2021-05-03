package p4;

import java.io.IOException;

public class Tester {
	
	public static void main(String args[]) throws InterruptedException
	{
		//create a new thread implementing runnable , using ano inner class : name of thread = test_me
		//execution logic : sleep for 5 seconds
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Press enter to continue");
					System.in.read();
					Thread.sleep(5000);
					System.out.println("Child's sleep over");
					
				} catch (InterruptedException  | IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("error in " + Thread.currentThread().getName() + e1);
				}
				
			}
		}, "test_me");//Main : runnable 
		
		
		t1.start();// Thread : // runnable
		//t1.start();//runnable thread can't be restarted : IllegalThreadException
		System.out.println("MAin before sleep");
		Thread.sleep(1000);
		System.out.println("Main after sleep waiting for child , interrupting t1");
		t1.interrupt();
		t1.join();//Main blocked on join
		//t1.start();//dead thread can't be restarted : IllegalThreadException
		System.out.println("Main over!!");
	}

}
