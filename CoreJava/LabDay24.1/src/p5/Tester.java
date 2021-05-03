package p5;

import java.io.IOException;

public class Tester {
	
	public static void main(String args[]) throws InterruptedException
	{
		
		Thread t1 = new Thread(()->{
			try {
				System.out.println("Press enter to continue , in which thread? " + Thread.currentThread().getName());
				System.in.read();
				Thread.sleep(5000);
				System.out.println("t1 sleep over");
				
			} catch ( IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("error in " + Thread.currentThread().getName() + e);
			}
		}, "t1");
		
		Thread t2 = new Thread(()->{
			try {
				System.out.println("Inside child thread 2 waiting for t1 to complete execution");
				t1.join();
				System.out.println("t2 returning after t1");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("error in " + Thread.currentThread().getName() + " " + e );
			}
		}, "t2");
		
		t1.start();
		t2.start();		
		System.out.println("Main after sleep waiting for child");
		t1.join(4000);//Main blocked for max 4 sec
		t2.join(3000);// Main blocked for max 3 sec
		System.out.println("Interrupt sent to t1 and t2");
		t1.interrupt();
		t2.interrupt();
		System.out.println("Main waiting again");
		t2.join();
		System.out.println("t2 over");
		t1.join();
		System.out.println("t1 over");
		System.out.println("Main over!!");
	}

}



//package p5;
//
//import java.io.IOException;
//
//public class Tester {
//
//	public static void main(String[] args) throws InterruptedException {
//		// create a new thread imple Runnable , using lambda expression : name of thread
//		// "test_me"
//		// exec logic : sleep : 5 sec
//		Thread t1 = new Thread(() -> {
//			try {
//				System.out.println("Press enter to continue....");
//				System.out.println("in which thrd ?  " + Thread.currentThread().getName());
//				System.in.read();// blocked on i/p
//				Thread.sleep(5000);// t1 : blocked on sleep
//				System.out.println("sleep over.....");
//			} catch (InterruptedException | IOException e) {
//				System.out.println("err in " + Thread.currentThread().getName() + " " + e);
//			} // t1 : dead
//
//		}, "t1");// 1 : main : runnable
//		Thread t2 = new Thread(() -> {
//			try {
//
//				System.out.println(Thread.currentThread().getName() + " waiting for t1 to complete exec");
//				t1.join();
//				System.out.println("t1 over...now terminating t2 ");
//			} catch (InterruptedException e) {
//				System.out.println("err in " + Thread.currentThread().getName() + " " + e);
//			} // t2 : dead
//
//		}, "t2");// 1 : main : runnable
//		t1.start();// 2 : runnable
//		t2.start();// main , t1 , t2 : all runnable
//		t1.join(4000); // main blocked on join : waiting for t1 : max for 4secs
//		t2.join(3000);// main blocked on join :waiting for t2 : max for 3 secs
//		System.out.println("main sending interrupt signal to t1 n t2");
//		t1.interrupt();
//		t2.interrupt();
//		System.out.println("main waiting again....");
//		t2.join();
//		System.out.println("t2 over....");
//		t1.join();
//		System.out.println("t1 over.....");
//		// until user presses enter : you won't see t1 over!!!!
//
//		System.out.println("main over....");
//
//	}
//
//}

