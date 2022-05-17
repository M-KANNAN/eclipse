
public class RightTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//RIGHT TRIANGLE PATTERN
		//declear variable i for ROW and j for COLUMN
		int row=6;
		
		for(int i=0;i<row;i++){
			for(int j=row-i;j>=1;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=row;i>0;i--){
			for(int j=row;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
