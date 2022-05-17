import java.util.HashSet;
import java.util.Scanner;

public class FizzBuzzproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//number is a multiple of 3 output="FIZZ"
		//number  is the multiple of 5 output="BUZZ"
		//number is the multiple of both 5 and 3 output="FIZZBUZZ"
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number ");
		int n=scanner.nextInt();
		
		fizzBuzz(n);
		

	}

	private static void fizzBuzz(int n) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder() ;
		
		for(int i=1;i<=n;i++) {
			if(i%3==0 && i%5 == 0) {
				sb.append("FizzBuzz"+" ");
			}
			else if(i%3 == 0) {
				sb.append("Fizz"+" ");
			}
			else if(i%5 ==0) {
				sb.append("Buzz"+" ");
			}
			else {
				sb.append(Integer.toString(i)+" ");
			}
			
			
		}
		System.out.println(sb);
	}

}
