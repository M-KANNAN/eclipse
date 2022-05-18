package Training;

import java.util.Scanner;

public class Program51 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number to be reversed :");
		long num=scanner.nextLong();
		long sum=0;
		while(num != 0) {
			sum=sum*10+num%10;
			num=num/10;
		}
		System.out.println(sum);
		scanner.close();
	}

}
