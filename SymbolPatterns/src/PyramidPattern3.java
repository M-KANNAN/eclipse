import java.util.*;
public class PyramidPattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		*************** SAMPLE OUTPUT ***********
//		
//		Enter the no of rows
//		5
//		          1
//		        1 2 1
//		      1 2 3 2 1
//		    1 2 3 4 3 2 1
//		  1 2 3 4 5 4 3 2 1
		
		
		//if rowCount=noOfRows the reverse pyramid
//		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the no of rows");
		int noOfRows=scanner.nextInt();
		int rowCount=1;
		for(int i=0;i<noOfRows;i++) {
			for(int j=2*(noOfRows-i);j>=1;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=rowCount;j++) {
				System.out.print(" "+j);
			}
			for(int j=rowCount-1;j>=1;j--) {
				System.out.print(" "+j);
			}
			System.out.println();
			rowCount++;
			 
		}
	}

}
