package Training;

import java.util.Scanner;

public class Program4 {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String [] args) {
		
		
		boolean isExite=true;
		while(isExite) {
			System.out.println("Enter Chocie : ");
			System.out.println("1 . bitwise-OR");
			System.out.println("2 . bitwise-AND");
			System.out.println("3 . bitwise-EX-OR");
			System.out.println("4 . bitwise-COMPLEMENT");
			System.out.println("5. Exit");
			byte choice=scanner.nextByte();
			switch (choice) {
				case 1:{
					bitwiseOR();
					break;
				}
				case 2:{
					bitwiseAND();
					break;
				}
				case 3:{
					bitwiseEXOR();
					break;
				}
				case 4:{
					bitwiseCOMP();
					break;
				}
				case 5 :{
					isExite=false;
				}
				
				

			default:
				break;
			}
		}
	}

	private static void bitwiseCOMP() {
		
		System.out.println("Entervalue :");
		byte a=scanner.nextByte();
		System.out.println("Bitwise-COMPLEMET "+(~a));
		System.out.println();
		
		
	}

	private static void bitwiseAND() {
		
		System.out.println("Enter a first value :");
		byte a=scanner.nextByte();
		System.out.println("Enter a second value :");
		byte b=scanner.nextByte();
		System.out.println("Bitwise-AND "+(a&b));
		System.out.println();
		
	}

	private static void bitwiseEXOR() {
		System.out.println("Enter a first value :");
		byte a=scanner.nextByte();
		System.out.println("Enter a second value :");
		byte b=scanner.nextByte();
		System.out.println("Bitwise-EX-OR "+(a^b));
		System.out.println();
		
	}

	private static void bitwiseOR() {
		System.out.println("Enter a first value :");
		byte a=scanner.nextByte();
		System.out.println("Enter a second value :");
		byte b=scanner.nextByte();
		System.out.println("Bitwise-OR "+(a|b));
		System.out.println();
		
	}

}
