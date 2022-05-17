



public class ThreadWithoutSynchronization implements Runnable{
	
	public void run() {
			System.out.println("Thread "+Thread.currentThread()+" is running");
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
		ThreadWithoutSynchronization synchronization=new ThreadWithoutSynchronization();
		Thread thread=new Thread(synchronization);
		thread.start();
		}
	}

}
