package threads3;
import static java.lang.Thread.currentThread;


public class Test1 {

	public static void main(String[] args)throws InterruptedException {
		System.out.println(currentThread());//1 thread without counting gc
		//Create runnable task instance
		RunnableTask task = new RunnableTask();//1 runnableTask generated
		//Thread class ctor : implements : threads(Runnable instance , String name)
		Thread t1 = new Thread(task, "one");
		Thread t2 = new Thread(task, "two");
		Thread t3 = new Thread(task, "three");
		Thread t4 = new Thread(task, "four");
		Thread t5 = new Thread(task, "five");

		// main : dummy logic 
		
		for (int i =0 ; i<10 ; i++)
		{
			System.out.println(currentThread().getName() + " execution counter : " + i);
			Thread.sleep(500);//State : Blocked on sleep
		}
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		System.out.println("Main waiting for child thread to complete the execution");
		System.out.println("thread status " + t1.isAlive() + "  " + t4.isAlive());//true true
		t1.join();
		t2.join();
		t3.join();t4.join();t5.join();
		System.out.println("child threads over");
		System.out.println("Main over");
	}

}


