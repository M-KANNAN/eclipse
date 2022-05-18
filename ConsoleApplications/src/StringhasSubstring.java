import java.util.Scanner;

public class StringhasSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String s1=new String();
		String s2=new String();
		
		System.out.println("enter the string");
		s1=scanner.next();
		
		System.out.println("Enter the substring");
		s2=scanner.next();
		
		boolean i=s1.contains(s2);
		System.out.println(i);
		//if substring present print the first occurance index
		// if not presnt print -1
		
		if(i==true) {
		
		System.out.println(s1.indexOf(s2));
		}
		else {
			System.out.println(-1);
		}
		
	}

}
