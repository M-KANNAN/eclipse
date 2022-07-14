package logicalQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String 1 ");
		String s1 = scanner.next().toLowerCase();
		System.out.println("Enter a String 2");
		String s2 = scanner.next().toLowerCase();

		System.out.println(anagramFinder(s1, s2) ? "ANAGRAM" : "NOT A ANAGRAM");

		scanner.close();

	}

	private static boolean anagramFinder(String s1, String s2) {

		String arr1[] = s1.split("");
		String arr2[] = s2.split("");

		String temp="";
		
		if(s1.length() != s2.length()) {
			return false;
		}
		else {
			for(int i=0;i<arr1.length;i++) {
				for(int j=i+1;j<arr1.length;j++) {
					if(arr1[i].compareTo(arr1[j]) > 0) {
						temp=arr1[i];
						arr1[i]=arr1[j];
						arr1[j]=temp;
					}
					if(arr2[i].compareTo(arr2[j]) > 0) {
						temp=arr2[i];
						arr2[i]=arr2[j];
						arr2[j]=temp;
					}
					
				}
			}
			return Arrays.equals(arr1, arr2);
		}
		
		//Arrays.sort(arr1);
		//Arrays.sort(arr2);

		

	}

}
