package Training;

import java.util.Scanner;

public class Program58 {

	public static void main(String[] args) {
		Scanner scanner=new  Scanner(System.in);
        System.out.println("Enter the no of rows");
        int noOfRows=scanner.nextInt();
        for(int i=0;i<noOfRows;i++) {
        	for(int j=noOfRows-i;j>0;j--) {
        		System.out.print("*");
        	}
        	for(int k=0;k<i;k++) {
        		System.out.print("_");
        	}
        	for(int k=0;k<i;k++) {
        		System.out.print("_");
        	}
        	for(int j=noOfRows-i;j>0;j--) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        
        
        for(int i=0;i<noOfRows;i++) {
        	
        	for(int k=0;k<=i;k++) {
        		System.out.print("*");
        	}
        	for(int j=noOfRows-i;j>1;j--) {
        		System.out.print("_");
        	}
        	for(int j=noOfRows-i;j>1;j--) {
        		System.out.print("_");
        	}
        	for(int k=0;k<=i;k++) {
        		System.out.print("*");
        	}
        	
        	System.out.println();
        }
        scanner.close();
        
	}

}
