package QueueAndThread;

import java.util.LinkedList;
import java.util.Queue;




class RecruitmentQueue{
	
	protected static Queue<Integer>  integers=new LinkedList<Integer>();

	public void addUsers() throws InterruptedException {
		
		synchronized (this) {
			
			for(int i=1;i<=10;i++) {
				
				if(i % 5 < 5) {
					System.out.println("Adding "+ i+" to Queue");
					Thread.sleep(300);
					integers.add(i);
				}
				else {
					wait();
					Thread.sleep(2000);
					
				}
				
			}
			
		}
		
	}

	public void removeUsers() throws InterruptedException {
		
		//Thread.sleep(1000);
		
		synchronized (this) {
			
			System.out.println();
			for(Integer integer:integers) {
				Thread.sleep(300);
				System.out.println("Allowing "+integer+" to Interview");
			}
			integers.clear();
			notify();
			
		}
		
		
		
	}
	
	
}


public class QueueAndThread {
	
	protected static Queue<Integer> integers=new LinkedList<>();
	

	public static void main(String[] args) throws InterruptedException  {
		
		RecruitmentQueue queue=new RecruitmentQueue();
		
		Thread  thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					queue.addUsers();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				
			}
		});
		
		Thread  thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					queue.removeUsers();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		thread1.start();
		thread1.join();
		
		thread2.start();
		thread2.join();
		
	}


}
