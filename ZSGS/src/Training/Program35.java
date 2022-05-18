package Training;

import java.util.Scanner;

public class Program35 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num=scanner.nextInt();
		int product=1;
		for(int i=1;i<=num;i++) {
			product=product*i;
		}
		int sum=0;
		while(product > 0) {
			sum=sum+product%10;
			product=product/10;
		}
		System.out.println("Sum of factorial's number :"+sum);
		scanner.close();
	}

}
