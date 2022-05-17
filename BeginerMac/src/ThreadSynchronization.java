

//THIS CAN BE DON BY PASSING THE OBJECT OF A NORMAL CLASS TO THE CLASS EXTEDNS THREAD CLASS
// NO PUBLIC CLASSES ALLOWED
class A{
	public void print(int i) {
		for(int j=0;j<5;j++) {
			System.out.println(i*j);
			try {
				Thread.sleep(1000);  //SLEEP IS MUST FOR SYNCHRONIZATION
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class A1 extends Thread{
	//FIRST CRAETE THE OBJECT OF "A" CLASS
	A obj;
	//create a constructor for class "A1"
	public A1(A obj1) { //passing the object of A as argument
		// this obj1 is assigned to obj
		obj=obj1;// obj is the object of A1 class
	}
	//create run() method and call the print() method
	public void run() {
		obj.print(10);
	}
}

class A2 extends Thread{
	A obj;
	public A2(A obj2) {
		obj=obj2;
	}
	public void run() {
		obj.print(100);
	}
}



public class ThreadSynchronization {

	public static void main(String[] args) {
		// CREATE OBJECT FOR CLASS A
		A obj=new A();
		//CREATE OBJECT FOR A1 AND A2 CLASSES
		A1 obj1=new A1(obj);//object of class A is passed as an argument
		A2 obj2=new A2(obj);
		obj1.start();
		obj2.start();

	}

}
