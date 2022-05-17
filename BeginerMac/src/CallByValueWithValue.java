
public class CallByValueWithValue {


	int data=50;
	void change(int data) {
		data=data+100;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Passing value
		CallByValueWithValue op=new CallByValueWithValue();
		System.out.println("Before calling "+op.data);
		op.change(500);
		System.out.println("After change "+op.data);
		

	}

}
