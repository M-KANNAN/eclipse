package Training;

import java.util.Scanner;

public class Program32 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number1 : ");
		int num1=scanner.nextInt();
		if(num1 > 0) {
			System.out.println("Positive  number");
		}
		else {
			System.out.println("Negative  number");
		}
		scanner.close();

	}

}
