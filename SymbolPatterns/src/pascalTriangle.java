import java.util.*;
public class pascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of rows ");
		int noOfRows=scanner.nextInt();
		for(int i=0;i<noOfRows;i++) {
			for(int j=(noOfRows-i);j>=1;j--) {
				System.out.print("  ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("  "+factorial(i)/(factorial(i-j)*factorial(j)));
			}
			System.out.println();
		}

	}

	private static int factorial(int i) {
		// TODO Auto-generated method stub
		if(i==0 ) {
			return 1;
		}
		else {
			return i*factorial(i-1);
		}
	
	}

}
