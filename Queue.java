import java.util.*;
import Exception.*;
import java.lang.Thread;


public class Queue<T> implements Runnable {
	
	private static final int DEFAULT_CAPACITY=10; 
	
	private int cap, // this is the total number of array currently
				front, // front index to dequeue 
				back, //back index to enqueue
				curr; // current number of elements in the queue
	
	// array to store the elements
	private T[] A; 
    
	//constructor
	public Queue() {
		front=0; back=-1; curr=0;
		cap = DEFAULT_CAPACITY;
		A = (T[]) new Object[DEFAULT_CAPACITY];
		//A = new T[DEFAULT_CAPACITY];
	}
	public boolean isEmpty() {
		return curr==0?true:false;
	}
	
	public boolean isFull() {
		return curr==cap?true:false;
	}
	
	public T poll() throws QueueException {
		if(isEmpty())
			throw new QueueException("The queue is empty");
	  
		else {
			T n = A[front%cap];
			front++;
			curr--;
			return n;
		}
		
	}
	
	public void offer(T a) throws QueueException {
		
		if(!isFull()) {
			back++;
			A[back%cap] = a;
			curr++;
		}
		else
		  throw new QueueException("The queue is full");
	}
	
	public T peek() {
		if(isEmpty())
			return null;
		else
			return A[front%cap];
	}
	public int size() {
		return curr;
	}
	@Override
	public void run(){
		//T a;
		//this.offer(T);
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> obj = new Queue<>();
		Thread t1 = new Thread(new Queue<Integer>());
		Thread t2 = new Thread(new Queue<Integer>());
		t1.start();
		t2.start();
		for(int i=0; i<=10; i++) {
			//if(!obj.offer(i)) 
				//System.out.println("queue is full");
			if(i%2==0) {
			try {
				obj.offer(i);
				System.out.println("size " + obj.size());
			} catch (QueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
			else {
				try {
					int n = obj.poll();
					System.out.println("remove element " + n);
				}
				catch(QueueException e) {
					e.printStackTrace();
				}
			}
         
		   //System.out.println("size " + obj.size());
		
				
		}
		
	}
  
}

