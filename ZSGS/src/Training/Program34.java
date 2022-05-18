package Training;

import java.util.Scanner;

public class Program34 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number to which the sum to found");
		int num=scanner.nextInt();
		int sum=0;
		for(int i=1;i<=num;i++) {
			sum=sum+i;
		}
		System.out.println("Sum of "+num+" Natural numbers is : "+sum);
		byte maxValue=0;
		byte rem=0;
		while(sum > 0) {
			rem=(byte) (sum%10);
			if(rem > maxValue) {
				maxValue=rem;
			}
			sum=sum/10;
		}
		System.out.println("Largest digit in a number is : "+maxValue);
		scanner.close();

	}

}
