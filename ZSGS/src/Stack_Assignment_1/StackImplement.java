package Stack_Assignment_1;

import java.util.Scanner;
import java.util.Stack;


class StackImplementation{
	
	protected static Stack<String> stack=new Stack<String>();
	
	

	public void stackPushing() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a string to push in the stack ");
		stack.push(scanner.next());
		System.out.println("!!! VALUE PUSHED !!!");
		
	}



	public void stackPoping() {
		if(!stack.isEmpty()) {
			System.out.println("Element poped : "+stack.pop());
		}
		else {
			System.out.println("!!! STACK IS EMPTY !!!");
		}
		
	}



	public void stackPeekElementChecker() {
		if(!stack.isEmpty()) {
			System.out.println("Peek element : "+stack.peek());
		}
		else {
			System.out.println("!!! STACK IS EMPTY !!!");
		}
		
	}
	
	
	
}

public class StackImplement{
	
	private void flowManager() {
		Scanner  scanner=new Scanner(System.in);
		boolean isExit=true;
		while(isExit) {
			System.out.println();
			System.out.println("  **Welcome to Stack Implementation**");
			System.out.println();
			System.out.println("Enter 1 to PUSH element to Stack");
			System.out.println("Enter 2 to POP element to Stack");
			System.out.println("Enter 3 to TOP/PEEK element to Stack");
			System.out.println("Enter 4 to Exit");
			byte choice=scanner.nextByte();
			switch(choice) {
				case 1 :
					new StackImplementation().stackPushing();
					break;
				case 2 :
					new StackImplementation().stackPoping();
					break;
				case 3 :
					new StackImplementation().stackPeekElementChecker();
					break;
				case 4 :
					isExit=false;
					System.out.println("!!! Thank You !!!");
					break;
				default :
					System.out.println("!!! Enter a valid choice !!!");
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new StackImplement().flowManager();

	}

	

}
