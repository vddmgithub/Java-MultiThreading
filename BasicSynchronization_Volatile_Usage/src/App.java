import java.util.Scanner;

class Proceesor extends Thread{
	
	private volatile boolean running = true;  
	
	public void run(){
		while(running){
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
}


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proceesor proc1  = new Proceesor();
		proc1.start();
		
		System.out.println("Process return to stop....");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		proc1.shutdown();
		
		}

}
