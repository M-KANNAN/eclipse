package Training;

import java.util.Scanner;

public class Program30 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number1 : ");
		int num1=scanner.nextInt();
		System.out.println("Enter number2 : ");
		int num2=scanner.nextInt();
		System.out.println("Enter number3 : ");
		int num3=scanner.nextInt();
		if(num1 > num2 && num1 > num3) {
			System.out.println("Number1 is greater");
		}
		else if (num2 > num3) {
			System.out.println("Number2 is greater");
		}
		else {
			System.out.println("Number3 is greater");
		}
		scanner.close();

	}

}
