
public class App {

		private int count;
	/**
	 * @param args
	 */
	
	public synchronized void  increment() {
		count++;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.doWork();
		
		
	}

	public void doWork() {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<1000; i++){
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<100000; i++){
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count: "+count);
	}

}
