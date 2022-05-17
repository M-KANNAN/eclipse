
public class PyramidPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variable i for row and j for column
		int i,j,row=6;
		
		//outer loop for row and inner loop for column
		
		for(i=0;i<row;i++) {
			//for spacing
			for(j=row-i;j>1;j--) {
				System.out.print(" ");//same line whitespace
			}
			for(j=0;j<=i;j++) {
				System.out.print(" *");
			}
			System.out.println();//next line for next row
		}
				

	}

}
