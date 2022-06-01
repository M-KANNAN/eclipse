import java.util.Scanner;

public class SpiralMatrix {
	
	
	private static void spiralMatrix(int i, int j, int row, int column, int[][] arr) {
		if(i >= row || j >= column) {
			return ;
		}
		for(int p=0;p<column;p++) {
			System.out.print(arr[i][p]+" "); //First ROW
		}
		for(int p=i+1;p<row;p++) {
			System.out.print(arr[p][column-1]+" "); //Last column
		}
		if(row -1 != i) {
			for(int p=column-2;p>=j;p--) {
				System.out.print(arr[row-1][p]+" "); // Last Row
			}
		}
		if(column -1 != j) {
			for(int p=row-2;p>i;p--) {
				System.out.print(arr[p][j]+" "); //First column
			}
		}
		
		spiralMatrix(i+1,j+1,row-1,column-1,arr);
	}

	public static void main(String[] args) {
		
		Scanner  scanner=new Scanner(System.in);
		System.out.println("Enter the row ");
		int row=scanner.nextInt();
		System.out.println("Enter the column");
		int column=scanner.nextInt();
		System.out.println("Enter the array elements");
		int arr[][] =new int[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		
		spiralMatrix(0,0,row,column,arr);

	}

	

}
