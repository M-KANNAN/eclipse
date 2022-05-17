import java.util.Scanner;

public class PalindromeOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner=new Scanner(System.in);
//		String number=new String();
//		StringBuilder builder=new StringBuilder();
//		System.out.println("Enter the number to be checked");
//		number=scanner.next();
//		builder.append(number);
//		builder.reverse();
//		System.out.println(builder);
//		if(builder.toString().equals(number)) {
//			System.out.println("Pallindrome");
//		}
//		else {
//			System.out.println("Not a palindrome");
//		}
		
		Scanner scanner=new  Scanner(System.in);
		System.out.println("Enter the number");
		long n=scanner.nextLong();
		
		if(n%10==0 && n!=0 || n<10 ) {
			System.out.println(" Not a palindrome");
		}
		long reversedNumber=0;
		while(n>reversedNumber) {
			long pop=n%10;
			reversedNumber=reversedNumber*10+pop;
			n=n/10;
		}
		if(n==reversedNumber || reversedNumber/10==n) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not a palindrome");
		}
		
	}

}
