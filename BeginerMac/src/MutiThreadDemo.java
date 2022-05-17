
public class MutiThreadDemo extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getName()+" current thread name");
		System.out.println(Thread.currentThread().getId()+" current thread ID");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++) {
			MutiThreadDemo obj=new MutiThreadDemo();
			obj.start();
		}

	}

}
//implements Runnable interface