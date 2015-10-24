import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class App {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<?>future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
					// TODO Auto-generated method stub
					Random random = new Random();
					int duration = random.nextInt(4000);
					
					if(duration > 2000)
						throw new IOException("Sleeping ....");
					
					System.out.println("Starting...");
					
					try {
						Thread.sleep(duration);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("Finished....");
					return duration;
				}
		});
		executor.shutdown();
		//executor.awaitTermination(1, TimeUnit.DAYS); This is not required beco get() is blocking call.
		try {
			System.out.println("Returning : "+future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
