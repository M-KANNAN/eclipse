package Training;

import java.util.Scanner;

public class Program50 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the no of rows");
        int noOfRows=scanner.nextInt();
        int count =noOfRows;
        for(int i=0;i<noOfRows;i++) {
        	for(int k =0;k<i;k++) {
        		System.out.print(" ");
        	}
        	for(int l=noOfRows-i;l>0;l--) {
        		System.out.print(" "+count);
        	}
        	System.out.println();
        	count--;
        }
        scanner.close();
		
	}

}
