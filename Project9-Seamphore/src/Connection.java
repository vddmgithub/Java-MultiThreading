import java.util.concurrent.Semaphore;


public class Connection {
	
	private static Connection instance = new Connection();
	private int connections;
	Semaphore semaphore = new Semaphore(10,true);  //true is for fairness which ever thread calls acquire first wil get it. If this paramter is set to false then fairness is not guarnateed.
	
	public static Connection getConnection(){
		return instance;
	}
	
	public void  connect() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			doConnect();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
		
	}
	
	public void doConnect(){
		
		
		
		synchronized (this) {
			connections++;
			System.out.println("Current Connections: "+connections);
		}

		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
		}
		
		
	}

}
