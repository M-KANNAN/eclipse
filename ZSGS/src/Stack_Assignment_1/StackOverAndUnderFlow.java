package Stack_Assignment_1;

import java.util.Stack;

public class StackOverAndUnderFlow {
	Stack<Byte> stack=new Stack<Byte>();
	
private void stackOverAndUnderFlowIllustrator() {
		stack.push((byte) 100);
		stack.push((byte)0);
		stack.push((byte)255);
		stack.push((byte)256);
		stack.push((byte)-100);
		stack.push((byte)-256);
		stack.push((byte)-257);
		System.out.println(stack);
		
	}

	public static void main(String[] args) {
		
		new StackOverAndUnderFlow().stackOverAndUnderFlowIllustrator();

	}

	

}
