import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Runner {
	
	private int count =0;
	ReentrantLock lock = new ReentrantLock();
	
	private Condition cond  = lock.newCondition();
	
	public void increment(){
		for(int i=0; i < 10000; i++){
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException{
		lock.lock();
		System.out.println("Waiting for the condition");
		cond.await(); //Lock is released
		try{
			increment();
		}catch(Exception e){
			System.err.println(e);
		}finally{
			lock.unlock();
		}
		System.out.println("Thread1 completes JOB");
	}
	
	public void secondThread() throws InterruptedException{
		Thread.sleep(1000);
		lock.lock(); //Acquires lock released by thread1.
		
		
		System.out.println("Press return key");
		new Scanner(System.in);
		cond.signal(); //Notifies thread1 to get ready to acquire lock.
		System.out.println("Releasing on condition");
		try{
			increment();
		}catch(Exception e){
			System.err.println(e);
		}finally{
			lock.unlock();
		}
		System.out.println("Thread2 Completes the JOB");
	}

	public void finshed() {
		// TODO Auto-generated method stub
		System.out.println("Finally count: "+count);
	}

}
