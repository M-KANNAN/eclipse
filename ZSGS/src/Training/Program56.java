package Training;

import java.util.Scanner;

public class Program56 {

	public static void main(String[] args) {
	
		Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the no of rows");
        int noOfRows=scanner.nextInt();
        int count=1;
        for(int i=0;i<noOfRows;i++) {
        	for(int k=noOfRows-i;k>0;k--) {
        		System.out.print(" ");
        	}
        	for(int j=1;j<=i;j++ ) {
        		System.out.print(" "+count);
        		count++;
        	}
        	System.out.println();
        }
		scanner.close();
	}

}
