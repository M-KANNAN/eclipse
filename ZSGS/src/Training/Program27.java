package Training;

import java.util.Scanner;

public class Program27 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number1 : ");
		int num1=scanner.nextInt();
		System.out.println("Enter number2 : ");
		int num2=scanner.nextInt();
		int temp=0;
		temp=num1;
		num1=num2;
		num2=temp;
		System.out.println("Number 1 "+num1);
		System.out.println("Number 2 "+num2);
		scanner.close();
	}

}
