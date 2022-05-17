
public class CallByValuePassingObject {

	int data=50;
	void change(CallByValuePassingObject op1) {
		op1.data=op1.data+100;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Passing object
		CallByValuePassingObject op=new CallByValuePassingObject();
		System.out.println("Before calling "+op.data);
		op.change(op);
		System.out.println("After change "+op.data);
		System.out.println(op instanceof CallByValuePassingObject);

	}

}
