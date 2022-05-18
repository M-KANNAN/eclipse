package Training;

import java.util.Scanner;

public class Program59 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string 1 : ");
		String s1=scanner.next();
		System.out.println("Enter string 2 :");
		String s2=scanner.next();
		System.out.println(s1.indexOf(s2));
		scanner.close();
		
	}

}
