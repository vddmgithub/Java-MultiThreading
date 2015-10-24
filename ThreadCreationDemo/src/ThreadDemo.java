
class Work implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread name: "+Thread.currentThread().getName());
	}
	
}


public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Work());
		t1.start();
		System.out.println("Main threadName: "+Thread.currentThread().getName());
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Sairam in thread2 space");
				System.out.println("Current Thread's name: "+Thread.currentThread().getName());
			}
		});
		
		t2.start();
	}

}
