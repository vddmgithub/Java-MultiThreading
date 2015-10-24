import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class Processor implements Runnable{

	private int id;
	
	public Processor(int id){
		this.id  = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting ...."+id);
		
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			
		}
		
		System.out.println("Ending ...."+id);
		
	}
	
}

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);

		for(int i=1; i< 5; i++){
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		System.out.println("All tasks are submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("All taskes completed");
	
	}

}
