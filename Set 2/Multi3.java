import static java.lang.System.out; // to shorten print statement
//import java.lang.Thread;

class Multi3 implements Runnable {
	public void run() {
		out.println("Thread is running");
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i + ", Thread ID: "); // cant use getId() without extending Thread class
		}
	}

	public static void main(String[] args) {
		Multi3 m1 = new Multi3();
		Thread t1 = new Thread(m1);
		t1.start();
		Thread t2 = new Thread(m1);
		t2.start();
	}

}
