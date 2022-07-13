package com.bankingapplication.methods;

import java.util.Scanner;

public class Applicationmethods {
	
	static byte count=0;
	
	public static final byte choiceValidator() {
		
		
		StringBuilder builder=new StringBuilder();
		Scanner scanner=new Scanner(System.in);
		boolean isExit=true;
		while(isExit) {
			builder.append(scanner.nextLine());
			if(builder.length() == 1 && Character.isDigit(builder.charAt(0)) || count >= 3) {
				isExit=false;
			}
			else {
				++count;
				System.out.println();
				System.out.println("!!! Enter a vaid input !!!");
				System.out.println();
				builder.setLength(0);
			}
			
		}
		if(count >= 3) {
			return 0;
		}
		else {
			return Byte.parseByte(builder.toString());
		}
	
		
	}
	

}
