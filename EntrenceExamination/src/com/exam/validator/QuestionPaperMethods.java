package com.exam.validator;

import java.util.Scanner;

public class QuestionPaperMethods {


	public static String questionAndOptionSetter(String s) {
		
		StringBuilder s1=new StringBuilder();
		s1.trimToSize();
		Scanner scanner=new Scanner(System.in);
		boolean repeater=true;
		while(repeater) {
			System.out.println("\t"+"Type a "+s);
			s1.append(scanner.nextLine());
			if(s1 != null && s1.toString().trim() != "") {
				repeater=false;
			}
			else {
				s1.setLength(0);
				System.out.println("\t"+"!!! Type the "+s+" again !!!");
			}
		}
		return s1.toString();
		
	}
	
	
	
	
	public static float scoreSetter() {
		
		StringBuilder s1=new StringBuilder();
		s1.trimToSize();
		Scanner scanner=new Scanner(System.in);
		
		boolean repeater=true;
		while(repeater) {
			System.out.println("\t"+"Enter a score for a Question ");
			s1.append(scanner.nextLine());
			if(s1.length() == 1  && Character.isDigit(s1.charAt(0))  &&  Float.parseFloat(s1.toString()) > 0 ) {
				repeater=false;
			}
			else if(s1.length() == 2  && Character.isDigit(s1.charAt(0)) && Character.isDigit(s1.charAt(1)) &&  Float.parseFloat(s1.toString()) > 0 && Float.parseFloat(s1.toString()) <= 20) {
				repeater=false;
			}
			else {
				s1.setLength(0);
				System.out.println("\t"+"!!! Type the score again !!!");
			}
		}
		float i=Float.parseFloat(s1.toString());
		return i;
		
	}
	
	
	
	
	public static String correctOptionSetter() {
		
		StringBuilder s1=new StringBuilder();
		s1.trimToSize();
		Scanner scanner=new Scanner(System.in);
		
		boolean repeater=true;
		while(repeater) {
			System.out.println("\t"+"Enter a correct option as 'optionA' or 'optionB' or optionC'");
			s1.append(scanner.nextLine().toLowerCase());
			if(s1.toString().equals("optiona") || s1.toString().equals("optionb") || s1.toString().equals("optionc")) {
				repeater=false;
			}
			else {
				s1.setLength(0);
				System.out.println("\t"+"!!! Type the correct option again !!!");
			}
		}
		return s1.toString();
	}
	
	
	
	public static boolean statusSetter() {
		
		StringBuilder s1=new StringBuilder();
		s1.trimToSize();
		Scanner scanner=new Scanner(System.in);
		boolean status=true;
		
		boolean repeater=true;
		while(repeater) {
			System.out.println("\t"+"Enter 'Yes' for question active and enter 'No' for question deactive ");
			s1.append(scanner.nextLine().toUpperCase());
			if(s1.toString().equalsIgnoreCase("Yes") || s1.toString().equalsIgnoreCase("No") ) {
				repeater=false;
					
				}
				else {
					s1.setLength(0);
					System.out.println("\t"+"!!! Type the status as Yes or No again !!!");
					System.out.println();
				}

		}
		if(s1.toString().equalsIgnoreCase("Yes")) {
			return true;
		}
		else {
			return false;
		}

	}
	
	
}
