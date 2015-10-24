import java.util.Random;


public class App {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
		
		System.out.println("Starting....");
		
		 Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Random ran = new Random();
				
				for(int i=0; i< 1E7; i++){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Thread Interrupted");
						break;
					}
					
					Math.sin(ran.nextDouble());
				}
			}
		});
		
		t.start();
		t.interrupt();
		t.join();
		System.out.println("Completed....");
	}

}
