package Training;

import java.util.Scanner;

public class Program19 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a value for A :");
		short a=scanner.nextShort();
		System.out.println("a+=a++ + ++a + –a + a–  : "+(a+=a++ + ++a + (--a) + (a--)));
		scanner.close();
		

	}

}
