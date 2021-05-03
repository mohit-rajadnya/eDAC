package threads2;
import static java.lang.Thread.currentThread;

public class Test1 {

	public static void main(String[] args)throws InterruptedException {
		System.out.println(currentThread());//1 thread without counting gc
		
		NewThread t1 = new NewThread("myThread1");
		NewThread t2 = new NewThread("myThread2");
		NewThread t3 = new NewThread("myThread3");
		NewThread t4 = new NewThread("myThread4");
		NewThread t5 = new NewThread("myThread5");
		// main : dummy logic 
		
		for (int i =0 ; i<10 ; i++)
		{
			System.out.println(currentThread().getName() + " execution counter : " + i);
			Thread.sleep(500);//State : Blocked on sleep
		}
		System.out.println("Main waiting for child thread to complete the execution");
		System.out.println("thread status " + t1.isAlive() + "  " + t4.isAlive());//true true
		t1.join();
		t2.join();
		t3.join();t4.join();t5.join();
		System.out.println("child threads over");
		System.out.println("Main over");
	}

}
