import java.util.Scanner;
public class PyramidPattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		************** SAMPLE OUTPUT***********
//		Enter the no of rows
//		5
//		         1
//		       2 1 2
//		     3 2 1 2 3
//		   4 3 2 1 2 3 4
//		 5 4 3 2 1 2 3 4 5

		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the no of rows");
		int noOfRows=scanner.nextInt();
		
		for(int i=1;i<=noOfRows;i++) {
			for(int j=2*(noOfRows-i);j>=1;j--) {
				System.out.print(" ");
			}
			for(int k=i;k>=1;k--) {
				System.out.print(" "+k);
			}
			for(int l=2;l<=i;l++) {
				System.out.print(" "+l);
			}
			System.out.println();
		}

	}

}
