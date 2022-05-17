import java.util.Scanner;

public class PyramidnumberPattern1 {
	
	
//	************** SAMPLE OUTPUT *************
//	
//	
//	Enter the no of rows
//	5
//	      1
//	     2 2
//	    3 3 3
//	   4 4 4 4
//	  5 5 5 5 5


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the no of rows");
		int noOfRows=scanner.nextInt();
		int rowCount=1;
		
		for(int i=0;i<noOfRows;i++) {
			for(int j=noOfRows-i;j>=1;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print(" "+rowCount);
			}
			rowCount++;
			System.out.println();
		}
		

	}

}
