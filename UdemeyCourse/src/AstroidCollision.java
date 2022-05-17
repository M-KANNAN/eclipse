import java.util.Arrays;
import java.util.Stack;

public class AstroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {10,-5,-15};
		System.out.println(Arrays.toString(astroidCollision(arr)));

	}

	private static int[] astroidCollision(int[] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int astroid : arr) {
			if (astroid > 0) // POSITIVE ALUE MEANS PUSH
				stack.push(astroid);
			else { // NEGATIVE MEANS FOLLOWING 
				while(!stack.isEmpty() && stack.peek() >0 && Math.abs(stack.peek()) < Math.abs(astroid)) {
					stack.pop(); //PEAK < NEGATIVE VALUE SO POP
				}
				if(stack.isEmpty() || stack.peek() <0) {
					stack.push(astroid); //STACK IS EMPTY OR CONTAIN NEGATIVE SO PUSH
				}
				else if(stack.peek() == Math.abs(astroid)) {
					stack.pop();//PEEK VALUE == NEGATIVE VALUE SO POP
				}
			}
		}
		int output[]=new int[stack.size()];
		for(int i=stack.size()-1;i>=0;i--) { //BACK LOOP BECAUSE LAST IN FIRST OUT IN STACK
			output[i]=stack.pop();
		}
		
		
		return output;
	}

}
