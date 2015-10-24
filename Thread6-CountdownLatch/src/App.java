import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{

	private CountDownLatch latch;  //Threadsafe class no need of synchronization
	
	public Processor(CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Started..."+Thread.currentThread().getName());
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}
	
}


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService  exector =  Executors.newFixedThreadPool(3);

		for(int i=0; i< 3 ; i++){
			exector.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}

}
