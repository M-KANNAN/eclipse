package Training;

import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		
		System.out.println("Enter the number : ");
		Scanner  scanner=new Scanner(System.in);
		byte number=scanner.nextByte();
		
		System.out.println();
		System.out.println("     Multiplication table    ");
		if(number > 0) {
			for(byte i=1;i<=12;i++) {
				System.out.println(i+" * "+number+" = "+(i*number));
			}
		}
		else {
			System.out.println("!!! Not Possible !!!");
		}
		
		System.out.println();
		System.out.println("    Subtraction table     ");
		
		if(number > 0) {
			for(byte i=number;i<=12+number;i++) {
				System.out.println(i+" - "+number+" = "+(i-number));
			}
		}
		else {
			System.out.println("!!! Not Possible !!!");
		}

		scanner.close();
	}

}
