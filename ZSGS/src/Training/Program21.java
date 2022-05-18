package Training;

import java.util.Scanner;

public class Program21 {

	public static void main(String[] args) {
		 Scanner scanner=new Scanner(System.in);
			System.out.println("Enter a value for Y :");
			short y=scanner.nextShort();
			System.out.println(" (++y * (y++ + 5)) : "+(++y * (y++ + 5)));
			scanner.close();

	}
}
