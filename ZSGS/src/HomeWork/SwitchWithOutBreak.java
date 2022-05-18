package HomeWork;

import java.util.Scanner;

public class SwitchWithOutBreak {

	public static void main(String[] args) {
		

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the character");
		char ch=scanner.next().charAt(0);
		byte choice=0;
		if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
			choice =1;
		}
		else if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			choice =1;
		}
		switch(choice) {
		case 1:
			System.out.println("Vovel");
			//break;
			
		default :
			System.out.println("Not a vovel");
			//break;
			
		}
		

	}

}
