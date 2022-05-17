import java.util.Scanner;

public class XPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String s1=new String();
		System.out.println("Enter the string for x format");
		s1=scanner.next();
		int len=s1.length();
		
		//For printing x Format String must be in ODD number
		
		if(len%2!=0) {
			for(int i=0;i<len;i++) {
				int j=len-1-i;
				for(int k=0;k<len;k++) {
					if(k==i||k==j) {
						System.out.print(s1.charAt(i));//note:print in same line
					}
					else {
						System.out.print(" ");//note : print in same line
					}
				}
				System.out.println();//for next word next line
			}
		
		}
		else {
			System.out.println("String must have odd characters");
		}

	}

}
