package Training;

import java.util.Scanner;

public class Program25 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System .in);
		System.out.println("Enter the divident :");
		float divident=scanner.nextFloat();
		System.out.println("Enter the divisor :");
		float divisor=scanner.nextFloat();
		System.out.println("Quotient : "+(divident/divisor));
		System.out.println("Reminder : "+(divident%divisor));
		scanner.close();

	}

}
