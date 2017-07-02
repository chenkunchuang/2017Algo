import java.lang.Thread;
import java.util.*;


public class QueueThreads implements Runnable{
	
	private int balance;
	
	public QueueThreads() {
		balance=0;
	}
	
	@Override
	public void run() {
		System.out.println(this.getName() + " is running");
		for(int i=0; i<20; i++) {
			System.out.println("current balance " + this.balance);
			if(Math.random()>0.5)
				balance+=100;
			else {
				if(balance==0)
					System.out.println("balance low");
				else
					balance+=100;
			
			}
		}
		
	}
	
	public String getName() {
		return this.toString();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Queue<Integer> q = new Queue<>();
		Thread t1 = new Thread(new QueueThreads());
		Thread t2 = new Thread(new QueueThreads());
		
		t1.start();
		t2.start();
		
		
	}

}
