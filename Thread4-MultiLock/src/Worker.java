import java.util.ArrayList;
import java.util.List;
import java.util.Random;

	
public class Worker {
	
	private Random random  = new Random();
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	
	private List<Integer> list1= new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	
	public void stageOne(){
		synchronized (list1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));	
		}
	}
	
	public void stageTwo(){
		synchronized (list2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}

	public void process(){
		for(int i=0; i<1000; i++){
			stageOne();
			stageTwo();
		}
	}
	
	public void main(){
		System.out.println("Starting....");
		Long start  = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		t1.start();
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		t2.start();
		
		
		Long end = System.currentTimeMillis();
		System.out.println("Time taken: "+(end - start));
		
		System.out.println("List 1 Size: "+list1.size());
		System.out.println("List 2 Size: "+list2.size());
	}
	

}
