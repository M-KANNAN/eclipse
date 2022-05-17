import java.util.*;
public class PyramidPattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		*************** SAMPLE OUTPUT**************
//		Enter the number of rows 
//		5
//		      1
//		     1 2
//		    1 2 3
//		   1 2 3 4
//		  1 2 3 4 5
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of rows ");
		int noOfRows=scanner.nextInt();
		int rowCount=1;
		for(int i=0;i<noOfRows;i++) {
			for(int j=noOfRows-i;j>=1;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=rowCount;j++) {
				System.out.print(" "+j);
			}
			System.out.println();
			rowCount++;
		}
	}

}
