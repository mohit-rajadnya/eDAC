package p1;

public class Tester {
	
	public static void main(String args[]) throws InterruptedException
	{
		//create a new thread implementing runnable , using ano inner class : name of thread = test_me
		//execution logic : sleep for 5 seconds
		
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					System.out.println("Inside child thread");
//					Thread.sleep(5000);
//					System.out.println("Child's sleep over");
//					
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					System.out.println("error in " + Thread.currentThread().getName());
//				}
//				
//			}
//		}, "test_me");
		
		Thread t1 = new Thread(()->{
			try {
				System.out.println("Inside child thread");
				Thread.sleep(5000);
				System.out.println("Child's sleep over");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("error in " + Thread.currentThread().getName());
			}
		}, "Test_me");
		t1.start();
		System.out.println("MAin before sleep");
		Thread.sleep(1000);
		System.out.println("Main after sleep waiting for child");
		t1.join();
		System.out.println("Main over!!");
	}

}
