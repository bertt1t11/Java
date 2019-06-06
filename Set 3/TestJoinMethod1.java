import static java.lang.System.out; // to shorten print statement
//import java.util.timer;

class TestJoinMethod1 extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i + ", Thread ID: " + getId() + ", Name: " + getName());
			System.out.println(Thread.currentThread().getName() + ", priority: " + getPriority()); // This is their method
		} // if you look at the output, on count #2 there is a hickup, just before thread 1 stops
	}

	public static void main(String args[]) {
		TestJoinMethod1 t1 = new TestJoinMethod1();
		TestJoinMethod1 t2 = new TestJoinMethod1();
		TestJoinMethod1 t3 = new TestJoinMethod1();
		TestJoinMethod1 t4 = new TestJoinMethod1();
		TestJoinMethod1 t5 = new TestJoinMethod1();

		t3.setName("Sonoo Jaiswal");
		System.out.println("After changing name of t3:" + t3.getName());
		System.out.println("Name of t1:" + t1.getName());
		System.out.println("Name of t2:" + t2.getName());
		System.out.println("Name of t3:" + t3.getName());
		System.out.println("id of t1:" + t1.getId());
		out.println("");

		t1.start();
		try {
			t1.join(1500); //(in ms). If you put t1.join(); it would delay until t1 is done before starting other threads
		} catch (Exception e) {
			System.out.println(e);
		}
		//As you can see, when t1 completes its task then t2 and t3 starts executing.
		t2.start();
		t3.start();

		t1.setName("Fucking Cat!");
		System.out.println("After changing name of t1:" + t1.getName());

		//sleep(3000);  // smh 
		t4.setName("Thread 4, 2nd run"); // will throw an exception (at least when the first ones are still running)
		t5.setName("Thread 5, 2nd run");
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MAX_PRIORITY);
		t4.start();
		t5.start();
		t1.setDaemon(true);//will throw exception here  
		// Use Thread.currentThread().isDaemon() to test it.
	}
}