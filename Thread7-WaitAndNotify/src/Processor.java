import java.util.Scanner;


public class Processor {

	public void produce() throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized (this) {
			System.out.println("Producer running...");
			wait();
			System.out.println("Produer Resumed again");
		}
		
	}

	public void consume() throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key...");
			sc.nextLine();
			System.out.println("Return Key Pressed");
			notify();
		}
	}

}
 