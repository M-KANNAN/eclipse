
public class ImplementationOfStackUsingArray {
	
	int arr[]=new int[5];
	int top=0;
	
	//pushing elements into the array
	
	private boolean push(int x) {
		arr[top]=x;
		top++;
		System.out.println("Element pushed into the array = "+x);
		return true;
	}
	
	//poping the top most element from the stack
	
	private void pop() {
		int x=arr[top-1];
		System.out.println("Element poped out from the top of the stack = "+x);
		top--;
	}
	
	//peek elemnt in the stack (TOP most elemnt in the stack)
	
	private int peek() {
		return arr[top-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementationOfStackUsingArray array=new ImplementationOfStackUsingArray();
		array.push(10);
		array.push(20);
		array.push(30);
		array.push(40);
//		array.push(50);
		array.pop();
		System.out.println("peak elemnt in the stack is = "+array.peek());
		

	}

}
