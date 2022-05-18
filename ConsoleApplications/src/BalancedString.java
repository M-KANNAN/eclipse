import java.util.Scanner;
import java.util.Stack;

public class BalancedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//{[()]} ==BalancedString
		//{[(]} ==UnBalancedString
		
		Scanner scanner=new Scanner(System.in);
		String str=new String();
		System.out.println("enter the String");
		str=scanner.next();
		
		//introducing the stack to store the opening  parenthesis

		Stack<Character> st=new Stack<>();
		
		//inserting open parenthesis
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(st.empty()) {
				st.push(c);
			}
			else if(c=='{' || c=='[' || c=='(') {
				st.push(c);
			}
			else if(c=='}' && st.peek()=='{') {
				st.pop();			
				}
			else if(c==']' && st.peek()=='[') {
				st.pop();
			}
			else if(c==')'&& st.peek()=='(') {
				st.pop();
			}
			
		}
		
		if(st.empty()) {
			System.out.println("BalancedString");
		}
		else {
			System.out.println("UnbalancedString");
		}
		
	}

}
