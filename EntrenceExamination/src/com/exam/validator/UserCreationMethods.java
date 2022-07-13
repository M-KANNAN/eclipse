package com.exam.validator;

import java.util.Scanner;

public class UserCreationMethods {
	
	StringBuilder  builder=new StringBuilder();
	
	protected String nameCreation() {
		Scanner scanner=new Scanner(System.in);
		builder.trimToSize();
		boolean isExit=true;

		while(isExit) {
			System.out.println();
			System.out.println("\t"+"Enter your name :");
			builder.append(scanner.nextLine());
			for(int j=0;j<builder.length();j++) {
				if(builder.toString().trim() != "" && builder.charAt(j) == '.' || builder.charAt(j) == ' ' || (builder.charAt(j) >= 'A' && builder.charAt(j) <= 'z') ) {
					continue;

				}
				else {
					builder.setLength(0);
					System.out.println("Name only contains '.' , 'A - Z' , 'a - z'");
					System.out.println();
					break;
				}
			}
			if(builder.length() > 0) {
				isExit=false;
			}
			else {
				builder.setLength(0);
				System.out.println("Name only contains '.' , 'A - Z' , 'a - z'");
				System.out.println();
			}
		}
		return builder.toString();
		
	}
	
	
	
	protected  String passwordCreator() {
		
		Scanner scanner=new Scanner(System.in);
		builder.trimToSize();
		boolean isExit=true;
		while(isExit) {
			System.out.println("\t"+"Enter your password  ");
			builder.append(scanner.nextLine());
			if(builder.length() > 8 && builder.length() < 20) {
				isExit=false;
			}
			else {
				System.out.println();
				System.out.println("\t\t\t!!! PASSWORD LENGTH MUST BE GREATER THAN '8' AND LESS THAN '20' !!!");
				System.out.println();
			}
		}
		
		return builder.toString();
	}
	
	

	
	
	protected  byte ageCreator() {
		Scanner scanner=new Scanner(System.in);
		boolean isExit=true;
		builder.trimToSize();
		while(isExit) {
			System.out.println("\t"+"Enter your age : ");
			builder.append(scanner.nextLine());
			if(builder.length() == 2 && Character.isDigit(builder.charAt(0))  && Character.isDigit(builder.charAt(1))) {
				if(Byte.parseByte(builder.toString()) > 18 && Byte.parseByte(builder.toString()) < 28) {
					isExit=false;
				}
				else {
					builder.setLength(0);
					System.out.println("\t\t\t\t!!! YOUR AGE LIMIT EXCEEDS !!!");
					System.out.println();
				}
			}
			if(builder.length() > 2) {
				builder.setLength(0);
				System.out.println("\t\t\t\t !!! INVALID INPUT !!!");
				System.out.println();
			}
		}
		return Byte.parseByte(builder.toString());
		
	}
	

	
	protected String quotaCreator() {
		Scanner scanner=new Scanner(System.in);
		builder.trimToSize();
		boolean isExit=true;
		while(isExit) {
			System.out.println("\t"+"Quota available OC,BC,SC,ST");
			System.out.println();
			System.out.println("\t"+"Enter your Quota : ");
			builder.append(scanner.nextLine().toUpperCase());
			if(builder.toString().equals("OC") || builder.toString().equals("BC")  || builder.toString().equals("SC")  || builder.toString().equals("ST") ) {
				isExit=false;
			}
			else {
				builder.setLength(0);
				System.out.println("\t\t\t\t!!! PLEASE ENTER VALID QUOTA !!!");
				System.out.println();
			}
		}
		return builder.toString();
		
	}
	
	

	protected String mobileNoCreator() {
		
		Scanner scanner=new Scanner(System.in);
		builder.trimToSize();
		boolean isExit=true;
		while(isExit) {
			System.out.println("\t"+"Enter your Mobile No  ");
			builder.append(scanner.nextLine());
			if(builder.toString().length() == 10) {
				for(int i =0;i<builder.length();i++) {
					if(! Character.isDigit(builder.charAt(i))) {
						builder.setLength(0);
						break;
					}
				}
			}
			else {
				builder.setLength(0);
			}
			if(builder.length() != 0) {
				isExit=false;
			}
			else {
				isExit=true;
				System.out.println();
				System.out.println("\t\t\t!!! MOBILE NUMBER MUST CONTAIN 10 NUMBERS !!!");
				System.out.println();
				System.out.println("\t\t\t!!! MOBILE NUMBER MUST CONTAIN NUMBERS !!!");
				System.out.println();
			}
		
		}
		
		return builder.toString();
		
	}

}
