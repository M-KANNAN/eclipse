package HomeWork;

import java.util.Scanner;

public class Xpattern {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String : ");
		String s1=scanner.next();
		if(s1.length() % 2 != 0) {
			for(int i=0;i<s1.length();i++) {
				int j=s1.length()-i-1;
				for(int k=0;k<s1.length();k++) {
					if(k == i || k == j) {
						System.out.print(s1.charAt(k));
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		else {
			System.out.println("!!! X-Pattern Impossible !!!");
		}
		
		scanner.close();
	}

}
