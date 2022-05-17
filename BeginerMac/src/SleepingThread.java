
public class SleepingThread extends Thread {

	public void run() {
		
		try {
			System.out.println(currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<3;i++) {
			SleepingThread sleepingThread=new SleepingThread();
			sleepingThread.start();
		}

	}

}
