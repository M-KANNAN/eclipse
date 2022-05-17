
public class Staticexample {

	static int a=10;
	int i=10;
	void print() {
		a=a+10;
		i=i+10;
		System.out.println("a= "+a+" i= "+i);
	}
	static {
		System.out.println("Before main method STSTIC BLOCK EXECUTED ");
	}
	static void display() {
		System.out.println(a+10);
	}
	
	
	public static void main(String[] args) {
		System.out.println("After main method");
		Staticexample staticexample=new Staticexample();
		staticexample.print();
		staticexample.display();
		System.out.println("After main method");
		Staticexample staticexample1=new Staticexample();
		staticexample1.print();
		staticexample1.display();
		
	}

}
