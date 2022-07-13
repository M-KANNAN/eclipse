package com.exam.validator;

import java.util.Scanner;

public class NumberBasedValidator {

	public static byte choiceChecker(){
		Scanner scanner=new Scanner(System.in);
		StringBuilder s1=new  StringBuilder();
		boolean isExite=true;
		while(isExite) {
			s1.append(scanner.nextLine());
			if(s1.length() == 1 && Character.isDigit(s1.charAt(0))) {
				isExite=false;
			}
			else {
				s1.setLength(0);
				System.out.println("\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
				System.out.println();
			}
		}
		byte i=Byte.parseByte(s1.toString());
		
		return i;

	}

	public static int questionNumberChecker() {
		
		Scanner scanner=new Scanner(System.in);
		StringBuilder s1=new  StringBuilder();
		boolean isExite=true;
		while(isExite) {

			System.out.println("\t"+"Enter the question number to update ");
			s1.append(scanner.nextLine());
			if( s1.length() == 1 && Character.isDigit(s1.charAt(0))) {
				isExite=false;
			}
			else if(s1.length() ==2 && Character.isDigit(s1.charAt(0)) && Character.isDigit(s1.charAt(1))) {
				isExite=false;
			}
			else {
				s1.setLength(0);
				System.out.println("\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
				System.out.println();
			}
		}
		int i=Integer.parseInt(s1.toString());
		return i;

	}	
	
	public static long idValidator(int len) {
		Scanner scanner=new Scanner(System.in);
		StringBuilder s1=new  StringBuilder();
		boolean isExite=true;
		while(isExite) {
			System.out.println("\t"+"Enter your Id");
			s1.append(scanner.nextLine());
			if(s1.length() == len) {
				for(int i=0;i<s1.length();i++) {
					if(Character.isDigit(s1.charAt(i))) {
						continue;
					}
					else {
						s1.setLength(0);
						System.out.println("\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
						System.out.println();
						break;
					}
				}
				if(s1.length() == len) {
					isExite=false;
				}
				
			}
			
			else {
				s1.setLength(0);
				System.out.println("\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
				System.out.println();
			}
			
		}
		long i=Long.parseLong(s1.toString());
		return i ;
		
	}

}
