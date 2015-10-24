import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class UsingThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Starting.....");

		ExecutorService exec = Executors.newCachedThreadPool();
		Future<?> fu = exec.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				// TODO Auto-generated method stub

				Random ran = new Random();

				for(int i=0; i< 1E7; i++){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Thread Interrupted");
						break;
					}

					Math.sin(ran.nextDouble());


				}
				return null;
			}
		});


		exec.shutdown();
		
		//Same as Interrupted flag is set. Two methods to Interrupt.
		//fu.cancel(true); 
		exec.shutdownNow();
		
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished....");
		

	}

}
